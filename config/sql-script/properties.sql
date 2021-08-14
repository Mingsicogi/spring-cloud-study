CREATE TABLE `properties` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `key` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL,
  `value` varchar(4096) COLLATE utf8mb4_unicode_ci NOT NULL,
  `application` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `profile` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `label` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `prop_key` (`key`,`application`,`profile`,`label`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;