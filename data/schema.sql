USE [uicard]
GO

/******************************DROP TABLE *************************************/
/****** Object:  Table [dbo].[Admin]    Script Date: 10/08/2013 13:28:06 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Admin]') AND type in (N'U'))
DROP TABLE [dbo].[Admin]
GO

IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Customer_Centre]') AND parent_object_id = OBJECT_ID(N'[dbo].[Customer]'))
ALTER TABLE [dbo].[Customer] DROP CONSTRAINT [FK_Customer_Centre]
GO

/****** Object:  Table [dbo].[Customer]    Script Date: 10/08/2013 13:33:54 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Customer]') AND type in (N'U'))
DROP TABLE [dbo].[Customer]
GO

IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Employee_Centre]') AND parent_object_id = OBJECT_ID(N'[dbo].[Employee]'))
ALTER TABLE [dbo].[Employee] DROP CONSTRAINT [FK_Employee_Centre]
GO

/****** Object:  Table [dbo].[Employee]    Script Date: 10/08/2013 13:31:20 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Employee]') AND type in (N'U'))
DROP TABLE [dbo].[Employee]
GO

IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Centre_Zone]') AND parent_object_id = OBJECT_ID(N'[dbo].[Centre]'))
ALTER TABLE [dbo].[Centre] DROP CONSTRAINT [FK_Centre_Zone]
GO

/****** Object:  Table [dbo].[Centre]    Script Date: 10/08/2013 13:29:31 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Centre]') AND type in (N'U'))
DROP TABLE [dbo].[Centre]
GO

/****** Object:  Table [dbo].[Zone]    Script Date: 10/10/2013 02:05:05 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Zone]') AND type in (N'U'))
DROP TABLE [dbo].[Zone]
GO







/***************CREATE TABLE******************/
/************* ADMIN TABLE**************/
/****** Object:  Table [dbo].[Admin]    Script Date: 10/08/2013 13:28:06 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Admin](
	[adminName] [varchar](100) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[email] [varchar](100) NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[adminName] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO
/************* ZONE TABLE ****************/
/****** Object:  Table [dbo].[Zone]    Script Date: 10/10/2013 02:05:05 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Zone](
	[pin_Code] [varchar](50) NOT NULL,
	[zone_Name] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Zone] PRIMARY KEY CLUSTERED 
(
	[Pin_Code] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


/************* CENTRE TABLE **************/
/****** Object:  Table [dbo].[Centre]    Script Date: 10/08/2013 13:29:31 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Centre](
	[centreCode] [varchar](50) NOT NULL,
	[pin_code] [varchar](50) NOT NULL,
	[centreName] [varchar](50) NOT NULL,
	[location] [varchar](50) NOT NULL,
	[ip] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Centre] PRIMARY KEY CLUSTERED 
(
	[centreCode] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Centre]  WITH CHECK ADD  CONSTRAINT [FK_Centre_Zone] FOREIGN KEY([pin_code])
REFERENCES [dbo].[Zone] ([pin_code])
GO

ALTER TABLE [dbo].[Centre] CHECK CONSTRAINT [FK_Centre_Zone]
GO

/************* EMPLOYEE TABLE**************/
/****** Object:  Table [dbo].[Employee]    Script Date: 10/08/2013 13:31:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Employee](
	[empID] [int] NOT NULL IDENTITY,
	[empName] [varchar](100) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[email] [varchar](100) NULL,
	[state] [bit] NULL,
	[centreCode] [varchar] (50) NOT NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[empID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Centre] FOREIGN KEY([centreCode])
REFERENCES [dbo].[Centre] ([centreCode])
GO

ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Centre]
GO

/************* CUSTOMER TABLE**************/
/****** Object:  Table [dbo].[Customer]    Script Date: 10/08/2013 13:33:54 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Customer](
	[cusID] [int] NOT NULL IDENTITY,
	[first_name] [varchar](50) NOT NULL,
	[middle_name] [varchar](50) NULL,
	[last_name] [varchar](50) NOT NULL,
	[dob] [datetime] NOT NULL,
	[gender] [smallint] NOT NULL,
	[contact_detail] [varchar](100) NULL,
	[email] [varchar](50) NULL,
	[address] [varchar](200) NOT NULL,
	[education] [varchar](200) NULL,
	[occupation] [varchar](100) NULL,
	[married] [bit] NULL,
	[passport] [bit] NULL,
	[voter] [bit] NULL,
	[driving_license] [bit] NULL,
	[health] [varchar](200) NULL,
	[centreCode] [varchar] (50) NOT NULL,
	[UICode] [varchar](15) NULL,
	[thumb] [bit] NULL,
	[fingerprint] [bit] NULL,
	[retina_scan] [bit] NULL,
	[status] [smallint] NULL,
	[personal_detail] [varchar](200) NULL,
	[created_date] [datetime] NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[cusID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Centre] FOREIGN KEY([centreCode])
REFERENCES [dbo].[Centre] ([centreCode])
GO

ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Centre]
GO




