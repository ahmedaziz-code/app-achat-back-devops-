
DROP TABLE IF EXISTS `categorie_produit`;
CREATE TABLE IF NOT EXISTS `categorie_produit` (
  `id_categorie_produit` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_categorie` varchar(255) DEFAULT NULL,
  `libelle_categorie` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_categorie_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `detail_facture`
--

DROP TABLE IF EXISTS `detail_facture`;
CREATE TABLE IF NOT EXISTS `detail_facture` (
  `id_detail_facture` bigint(20) NOT NULL AUTO_INCREMENT,
  `montant_remise` float NOT NULL,
  `pourcentage_remise` int(11) DEFAULT NULL,
  `prix_total_detail` float NOT NULL,
  `qte_commandee` int(11) DEFAULT NULL,
  `facture_id_facture` bigint(20) DEFAULT NULL,
  `produit_id_produit` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_detail_facture`),
  KEY `FKo4yc7y45xlhgtxdutts3p9yo4` (`facture_id_facture`),
  KEY `FKptlermnhcwe51qffww9v1yl0k` (`produit_id_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `detail_fournisseur`
--

DROP TABLE IF EXISTS `detail_fournisseur`;
CREATE TABLE IF NOT EXISTS `detail_fournisseur` (
  `id_detail_fournisseur` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `date_debut_collaboration` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `matricule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_detail_fournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `id_facture` bigint(20) NOT NULL AUTO_INCREMENT,
  `archivee` bit(1) DEFAULT NULL,
  `date_creation_facture` date DEFAULT NULL,
  `date_derniere_modification_facture` date DEFAULT NULL,
  `montant_facture` float NOT NULL,
  `montant_remise` float NOT NULL,
  `fournisseur_id_fournisseur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_facture`),
  KEY `FK2pphg0s5146xjyhpyhfpa419l` (`fournisseur_id_fournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id_fournisseur` bigint(20) NOT NULL AUTO_INCREMENT,
  `categorie_fournisseur` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `detail_fournisseur_id_detail_fournisseur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_fournisseur`),
  KEY `FKq5vad51fs51xymlrtju4m2b9r` (`detail_fournisseur_id_detail_fournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur_secteur_activites`
--

DROP TABLE IF EXISTS `fournisseur_secteur_activites`;
CREATE TABLE IF NOT EXISTS `fournisseur_secteur_activites` (
  `fournisseurs_id_fournisseur` bigint(20) NOT NULL,
  `secteur_activites_id_secteur_activite` bigint(20) NOT NULL,
  PRIMARY KEY (`fournisseurs_id_fournisseur`,`secteur_activites_id_secteur_activite`),
  KEY `FKllqt521h3meitfrk3c7klahtk` (`secteur_activites_id_secteur_activite`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `operateur`
--

DROP TABLE IF EXISTS `operateur`;
CREATE TABLE IF NOT EXISTS `operateur` (
  `id_operateur` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_operateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `operateur_factures`
--

DROP TABLE IF EXISTS `operateur_factures`;
CREATE TABLE IF NOT EXISTS `operateur_factures` (
  `operateur_id_operateur` bigint(20) NOT NULL,
  `factures_id_facture` bigint(20) NOT NULL,
  PRIMARY KEY (`operateur_id_operateur`,`factures_id_facture`),
  UNIQUE KEY `UK_blem3wdqx1227f9xkqgnwcu2j` (`factures_id_facture`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id_produit` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_produit` varchar(255) DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  `date_derniere_modification` date DEFAULT NULL,
  `libelle_produit` varchar(255) DEFAULT NULL,
  `prix` float NOT NULL,
  `categorie_produit_id_categorie_produit` bigint(20) DEFAULT NULL,
  `stock_id_stock` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_produit`),
  KEY `FKffpayryoug1422jxg4wlgr3ak` (`categorie_produit_id_categorie_produit`),
  KEY `FKev4l89l3r0e9ogj935x8nsdfb` (`stock_id_stock`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reglement`
--

DROP TABLE IF EXISTS `reglement`;
CREATE TABLE IF NOT EXISTS `reglement` (
  `id_reglement` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_reglement` date DEFAULT NULL,
  `montant_paye` float NOT NULL,
  `montant_restant` float NOT NULL,
  `payee` bit(1) DEFAULT NULL,
  `facture_id_facture` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_reglement`),
  KEY `FK5dxl3urxbrs35sol5hoxmb755` (`facture_id_facture`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `secteur_activite`
--

DROP TABLE IF EXISTS `secteur_activite`;
CREATE TABLE IF NOT EXISTS `secteur_activite` (
  `id_secteur_activite` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_secteur_activite` varchar(255) DEFAULT NULL,
  `libelle_secteur_activite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_secteur_activite`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `id_stock` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle_stock` varchar(255) DEFAULT NULL,
  `qte` int(11) DEFAULT NULL,
  `qte_min` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_stock`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_facture`
--
ALTER TABLE `detail_facture`
  ADD CONSTRAINT `FKo4yc7y45xlhgtxdutts3p9yo4` FOREIGN KEY (`facture_id_facture`) REFERENCES `facture` (`id_facture`),
  ADD CONSTRAINT `FKptlermnhcwe51qffww9v1yl0k` FOREIGN KEY (`produit_id_produit`) REFERENCES `produit` (`id_produit`);

--
-- Constraints for table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FK2pphg0s5146xjyhpyhfpa419l` FOREIGN KEY (`fournisseur_id_fournisseur`) REFERENCES `fournisseur` (`id_fournisseur`);

--
-- Constraints for table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD CONSTRAINT `FKq5vad51fs51xymlrtju4m2b9r` FOREIGN KEY (`detail_fournisseur_id_detail_fournisseur`) REFERENCES `detail_fournisseur` (`id_detail_fournisseur`);

--
-- Constraints for table `fournisseur_secteur_activites`
--
ALTER TABLE `fournisseur_secteur_activites`
  ADD CONSTRAINT `FK6b9f3m4w6c3vy3xy160xd3t9l` FOREIGN KEY (`fournisseurs_id_fournisseur`) REFERENCES `fournisseur` (`id_fournisseur`),
  ADD CONSTRAINT `FKllqt521h3meitfrk3c7klahtk` FOREIGN KEY (`secteur_activites_id_secteur_activite`) REFERENCES `secteur_activite` (`id_secteur_activite`);

--
-- Constraints for table `operateur_factures`
--
ALTER TABLE `operateur_factures`
  ADD CONSTRAINT `FKrgr8rgievvo95rvhdreg5lqwq` FOREIGN KEY (`factures_id_facture`) REFERENCES `facture` (`id_facture`),
  ADD CONSTRAINT `FKthvl793sgcnwyihwwpevgt69w` FOREIGN KEY (`operateur_id_operateur`) REFERENCES `operateur` (`id_operateur`);

--
-- Constraints for table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FKev4l89l3r0e9ogj935x8nsdfb` FOREIGN KEY (`stock_id_stock`) REFERENCES `stock` (`id_stock`),
  ADD CONSTRAINT `FKffpayryoug1422jxg4wlgr3ak` FOREIGN KEY (`categorie_produit_id_categorie_produit`) REFERENCES `categorie_produit` (`id_categorie_produit`);

--
-- Constraints for table `reglement`
--
ALTER TABLE `reglement`
  ADD CONSTRAINT `FK5dxl3urxbrs35sol5hoxmb755` FOREIGN KEY (`facture_id_facture`) REFERENCES `facture` (`id_facture`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
