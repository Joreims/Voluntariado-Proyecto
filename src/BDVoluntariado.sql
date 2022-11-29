USE [BDVoluntariado]
GO
/****** Object:  Table [dbo].[Actividades]    Script Date: 29/11/2022 17:11:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actividades](
	[actividadID] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [nvarchar](50) NULL,
	[hora] [nvarchar](50) NULL,
	[descripcion] [nvarchar](50) NULL,
 CONSTRAINT [PK_Actividades] PRIMARY KEY CLUSTERED 
(
	[actividadID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Persona]    Script Date: 29/11/2022 17:11:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Persona](
	[nombres] [nvarchar](50) NULL,
	[apellidos] [nvarchar](50) NULL,
	[cedula] [nvarchar](50) NULL,
	[fechaNac] [nvarchar](50) NULL,
	[celular] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 29/11/2022 17:11:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[password] [nvarchar](50) NULL,
	[nombres] [nvarchar](50) NULL,
	[apellidos] [nvarchar](50) NULL,
	[cedula] [nvarchar](50) NULL,
	[fechaNac] [nvarchar](50) NULL,
	[celular] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voluntario]    Script Date: 29/11/2022 17:11:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voluntario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombres] [nvarchar](50) NULL,
	[apellidos] [nvarchar](50) NULL,
	[cedula] [nvarchar](50) NULL,
	[fechaNac] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_Voluntario] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Actividades] ON 
GO
INSERT [dbo].[Actividades] ([actividadID], [fecha], [hora], [descripcion]) VALUES (1, N'20-12-2022', N'12 P.M', N'Voluntariado UCA')
GO
SET IDENTITY_INSERT [dbo].[Actividades] OFF
GO
SET IDENTITY_INSERT [dbo].[Voluntario] ON 
GO
INSERT [dbo].[Voluntario] ([id], [nombres], [apellidos], [cedula], [fechaNac], [email]) VALUES (1, N'Jose', N'Zapata', N'2121212', N'20-10-2005', N'jose@gmail.com')
GO
INSERT [dbo].[Voluntario] ([id], [nombres], [apellidos], [cedula], [fechaNac], [email]) VALUES (2, N'Jorge', N'Garcia', N'1234123412312', N'223123', N'jdajdijdijd')
GO
INSERT [dbo].[Voluntario] ([id], [nombres], [apellidos], [cedula], [fechaNac], [email]) VALUES (3, N'Jose', N'adasds', N'dasdds', N'ddadsa', N'adsadsad')
GO
INSERT [dbo].[Voluntario] ([id], [nombres], [apellidos], [cedula], [fechaNac], [email]) VALUES (4, N'dajdjsda', N'dadadas', N'dasdads', N'dasdsad', N'dasdasd')
GO
INSERT [dbo].[Voluntario] ([id], [nombres], [apellidos], [cedula], [fechaNac], [email]) VALUES (5, N'Harry', N'Bodan', N'20120121F', N'20 Febrero 20005', N'harrybodan@gmai.com')
GO
SET IDENTITY_INSERT [dbo].[Voluntario] OFF
GO
