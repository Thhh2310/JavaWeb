CREATE TABLE USER_ACCOUNT(
	CusID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	CusUser varchar(25) NOT NULL,
	CusPass varchar(32) NOT NULL,
	CusName varchar(50) NOT NULL,
	CusPhone varchar(12) NOT NULL UNIQUE,
	CusAdd varchar(255) NOT NULL,
	CusEmail varchar(50) NOT NULL,
	CusFacebook varchar(150) NOT NULL,
	CusSkyper varchar(150) NOT NULL,
	CusStatus tinyint NOT NULL,
)
GO


INSERT USER_ACCOUNT ( [CusUser], [CusPass], [CusName], [CusPhone], [CusAdd], [CusEmail], [CusFacebook], [CusSkyper], [CusStatus])
VALUES (N'admin', N'admin', N'Vu Thao', N'0357618673', N'NGUYEN TRAI', N'vuthao23102003@gmail.com', N'https://www.facebook.com/deveduvn', NULL, 1)

INSERT USER_ACCOUNT ( [CusUser], [CusPass], [CusName], [CusPhone], [CusAdd], [CusEmail], [CusFacebook], [CusSkyper], [CusStatus])
VALUES (N'Devmaster', N'DEV@123', N'Devmaster Academy', N'0394857628', N'Devmaster Academy', N'tambang@gmail.com', N'https://www.facebook.com/tambang111', NULL, 1)

INSERT USER_ACCOUNT ( [CusUser], [CusPass], [CusName], [CusPhone], [CusAdd], [CusEmail], [CusFacebook], [CusSkyper], [CusStatus])
VALUES (N'DevSales', N'DevSales@123', N'Dev Sales', N'0354789176', N'25 Vu Ngoc Phan', N'devmaster.contact@gmail.com', N'https://www.facebook.com/devmasteracademy', NULL, 1)

INSERT USER_ACCOUNT ( [CusUser], [CusPass], [CusName], [CusPhone], [CusAdd], [CusEmail], [CusFacebook], [CusSkyper], [CusStatus])
VALUES (N'DevMarketing ', N'devmarketing', N'Dev Marketing', N'0399562876', N'NGUYEN TRAI', N'vuthao23102003@gmail.com', NULL, NULL, 1)

INSERT USER_ACCOUNT ( [CusUser], [CusPass], [CusName], [CusPhone], [CusAdd], [CusEmail], [CusFacebook], [CusSkyper], [CusStatus])
VALUES (N'ms30', N'123456789', N'djkdhsg', N'djkdhsg', N'djkdhsg', N'ms30@khongco.com', NULL, NULL, 1)

GO

