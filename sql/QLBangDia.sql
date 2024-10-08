USE [master]
GO
/****** Object:  Database [QLBangDia]    Script Date: 11/11/2023 9:13:32 PM ******/
CREATE DATABASE [QLBangDia]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLBangDia', FILENAME = N'D:\HE_CO_SO_DL\QLTV\QLBangDia\QLBangDia.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLBangDia_log', FILENAME = N'D:\HE_CO_SO_DL\QLTV\QLBangDia\QLBangDia_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QLBangDia] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLBangDia].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLBangDia] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLBangDia] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLBangDia] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLBangDia] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLBangDia] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLBangDia] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLBangDia] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLBangDia] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLBangDia] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLBangDia] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLBangDia] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLBangDia] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLBangDia] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLBangDia] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLBangDia] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLBangDia] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLBangDia] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLBangDia] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLBangDia] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLBangDia] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLBangDia] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLBangDia] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLBangDia] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLBangDia] SET  MULTI_USER 
GO
ALTER DATABASE [QLBangDia] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLBangDia] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLBangDia] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLBangDia] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLBangDia] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLBangDia] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLBangDia] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLBangDia] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLBangDia]
GO
/****** Object:  Table [dbo].[BangDia]    Script Date: 11/11/2023 9:13:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangDia](
	[maBangDia] [nvarchar](50) NOT NULL,
	[tenBangDia] [nvarchar](50) NOT NULL,
	[theLoai] [nvarchar](50) NOT NULL,
	[tinhTrang] bit NOT NULL,
	[hangSanXuat] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_BangDia] PRIMARY KEY CLUSTERED 
(
	[maBangDia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTPhieuThue]    Script Date: 11/11/2023 9:13:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTPhieuThue](
	[maPhieuThue] [nvarchar](50) NOT NULL,
	[maBangDia] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
	[soNgayDuocMuon] [int] NOT NULL,
 CONSTRAINT [PK_CTPhieuThue_1] PRIMARY KEY CLUSTERED 
(
	[maBangDia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/11/2023 9:13:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](50) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[SDT] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[CMND] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[gioiTinh] bit NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/11/2023 9:13:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](50) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[CMND] [nvarchar](50) NOT NULL,
	[SDT] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[gioiTinh] bit NOT NULL,
	[tinhTrang] bit NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuThue]    Script Date: 11/11/2023 9:13:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuThue](
	[maPhieuThue] [nvarchar](50) NOT NULL,
	[maNhanVien] [nvarchar](50) NOT NULL,
	[maKhachHang] [nvarchar](50) NOT NULL,
	[ngayLap] [date] NOT NULL,
 CONSTRAINT [PK_PhieuThue] PRIMARY KEY CLUSTERED 
(
	[maPhieuThue] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/11/2023 9:13:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maNhanVien] [nvarchar](50) NOT NULL,
	[matKhau] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BangDia] ([maBangDia], [tenBangDia], [theLoai], [tinhTrang], [hangSanXuat], [ghiChu]) VALUES (N'1', N'SieuNhanGao', N'hanh dong',1, N'Japan', N'tap 12')
INSERT [dbo].[BangDia] ([maBangDia], [tenBangDia], [theLoai], [tinhTrang], [hangSanXuat], [ghiChu]) VALUES (N'2', N'dat rung phuong na,', N'tinh cam', 0, N'vietnam', N'phan 1')
INSERT [dbo].[BangDia] ([maBangDia], [tenBangDia], [theLoai], [tinhTrang], [hangSanXuat], [ghiChu]) VALUES (N'3', N'em chua 18', N'tinh cam', 1, N'wapVjppro', N'full bo')
INSERT [dbo].[BangDia] ([maBangDia], [tenBangDia], [theLoai], [tinhTrang], [hangSanXuat], [ghiChu]) VALUES (N'4', N'son tung MTP', N'nhac tre', 0, N'MTP Entertaiment', N'30 bai hat')
GO
INSERT [dbo].[CTPhieuThue] ([maPhieuThue], [maBangDia], [soLuong], [donGia], [soNgayDuocMuon]) VALUES (N'1', N'1', 5, 8, 16)
INSERT [dbo].[CTPhieuThue] ([maPhieuThue], [maBangDia], [soLuong], [donGia], [soNgayDuocMuon]) VALUES (N'2', N'2', 4, 9, 10)
INSERT [dbo].[CTPhieuThue] ([maPhieuThue], [maBangDia], [soLuong], [donGia], [soNgayDuocMuon]) VALUES (N'3', N'3', 12, 44, 17)
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [SDT], [Email], [CMND], [diaChi],[gioiTinh]) VALUES (N'1', N'Nam', N'0909878765', N'Nam@gmail.com', N'9898717168', N'America',1)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [SDT], [Email], [CMND], [diaChi],[gioiTinh]) VALUES (N'2', N'Nhu', N'0998877665', N'Nhu@gmail.com', N'09987651261', N'Korean',1)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [SDT], [Email], [CMND], [diaChi],[gioiTinh]) VALUES (N'3', N'Duong', N'1223344556', N'Duong@gmail.com', N'9087908098', N'the Sun',0)
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [CMND], [SDT], [diaChi], [gioiTinh], [tinhTrang], [ngayVaoLam]) VALUES (N'1', N'Minh', N'01010101098239', N'0987654321', N'go vap',0, 1, CAST(N'2023-09-09' AS Date))
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [CMND], [SDT], [diaChi], [gioiTinh], [tinhTrang], [ngayVaoLam]) VALUES (N'2', N'Nguyen', N'982829827716', N'987987987879', N'bien hoa',0, 1, CAST(N'2023-10-10' AS Date))
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [CMND], [SDT], [diaChi], [gioiTinh], [tinhTrang], [ngayVaoLam]) VALUES (N'3', N'Phuc', N'90829287929', N'908798787987', N'go vap',0, 0, CAST(N'2019-09-09' AS Date))
GO
INSERT [dbo].[PhieuThue] ([maPhieuThue], [maNhanVien], [maKhachHang], [ngayLap]) VALUES (N'1', N'1', N'1', CAST(N'2023-11-11' AS Date))
INSERT [dbo].[PhieuThue] ([maPhieuThue], [maNhanVien], [maKhachHang], [ngayLap]) VALUES (N'2', N'3', N'2', CAST(N'2022-09-08' AS Date))
INSERT [dbo].[PhieuThue] ([maPhieuThue], [maNhanVien], [maKhachHang], [ngayLap]) VALUES (N'3', N'3', N'3', CAST(N'2003-09-07' AS Date))
GO
INSERT [dbo].[TaiKhoan] ([maNhanVien], [matKhau]) VALUES (N'1', N'123456')
INSERT [dbo].[TaiKhoan] ([maNhanVien], [matKhau]) VALUES (N'2', N'123456')
INSERT [dbo].[TaiKhoan] ([maNhanVien], [matKhau]) VALUES (N'3', N'123456')
GO
ALTER TABLE [dbo].[CTPhieuThue]  WITH CHECK ADD  CONSTRAINT [FK_CTPhieuThue_BangDia] FOREIGN KEY([maBangDia])
REFERENCES [dbo].[BangDia] ([maBangDia])
GO
ALTER TABLE [dbo].[CTPhieuThue] CHECK CONSTRAINT [FK_CTPhieuThue_BangDia]
GO
ALTER TABLE [dbo].[CTPhieuThue]  WITH CHECK ADD  CONSTRAINT [FK_CTPhieuThue_PhieuThue] FOREIGN KEY([maPhieuThue])
REFERENCES [dbo].[PhieuThue] ([maPhieuThue])
GO
ALTER TABLE [dbo].[CTPhieuThue] CHECK CONSTRAINT [FK_CTPhieuThue_PhieuThue]
GO
ALTER TABLE [dbo].[PhieuThue]  WITH CHECK ADD  CONSTRAINT [FK_PhieuThue_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[PhieuThue] CHECK CONSTRAINT [FK_PhieuThue_KhachHang]
GO
ALTER TABLE [dbo].[PhieuThue]  WITH CHECK ADD  CONSTRAINT [FK_PhieuThue_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuThue] CHECK CONSTRAINT [FK_PhieuThue_NhanVien]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [QLBangDia] SET  READ_WRITE 
GO
