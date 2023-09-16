CREATE SCHEMA IF NOT EXISTS `furuneko` DEFAULT CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS `furuneko`.`admins` (
  `id`            VARCHAR(22)  NOT NULL,          -- ユーザーID
  `email`         VARCHAR(256) NULL DEFAULT NULL, -- メールアドレス
  `created_at`    DATETIME(3)  NOT NULL,          -- 登録日時
  `updated_at`    DATETIME(3)  NOT NULL,          -- 更新日時
  PRIMARY KEY(`id`)
);
