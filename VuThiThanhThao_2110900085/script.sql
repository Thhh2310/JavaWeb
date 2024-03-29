USE [VuThiThanhThao_2110900085_db]
GO
/****** Object:  Table [dbo].[VuThiThanhThao_2110900085_Book]    Script Date: 23/02/2024 4:48:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VuThiThanhThao_2110900085_Book](
	[MaSach_msv] [varchar](50) NOT NULL,
	[TenSach_msv] [nvarchar](50) NOT NULL,
	[SoLuong_msv] [int] NOT NULL,
	[DonGia_msv] [float] NOT NULL,
	[Anh_msv] [varbinary](50) NULL
) ON [PRIMARY]
GO
