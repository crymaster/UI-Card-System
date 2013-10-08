USE [uicard]
GO

/************* ADMIN TABLE**************/
/****** Object:  Table [dbo].[Admin]    Script Date: 10/08/2013 13:28:06 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Admin]') AND type in (N'U'))
DROP TABLE [dbo].[Admin]
GO

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
/************* CENTRE TABLE**************/
/****** Object:  Table [dbo].[Centre]    Script Date: 10/08/2013 13:29:31 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Centre]') AND type in (N'U'))
DROP TABLE [dbo].[Centre]
GO

/****** Object:  Table [dbo].[Centre]    Script Date: 10/08/2013 13:29:31 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Centre](
	[centreID] [int] NOT NULL,
	[centreName] [varchar](50) NOT NULL,
	[centreCode] [varchar](50) NOT NULL,
	[location] [varchar](50) NOT NULL,
	[ip] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Centre] PRIMARY KEY CLUSTERED 
(
	[centreID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

/************* EMPLOYEE TABLE**************/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Employee_Centre]') AND parent_object_id = OBJECT_ID(N'[dbo].[Employee]'))
ALTER TABLE [dbo].[Employee] DROP CONSTRAINT [FK_Employee_Centre]
GO

/****** Object:  Table [dbo].[Employee]    Script Date: 10/08/2013 13:31:20 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Employee]') AND type in (N'U'))
DROP TABLE [dbo].[Employee]
GO

USE [uicard]
GO

/****** Object:  Table [dbo].[Employee]    Script Date: 10/08/2013 13:31:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Employee](
	[empID] [int] NOT NULL,
	[empName] [varchar](100) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[email] [varchar](100) NULL,
	[centreID] [int] NOT NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[empID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Centre] FOREIGN KEY([centreID])
REFERENCES [dbo].[Centre] ([centreID])
GO

ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Centre]
GO

/************* CUSTOMER TABLE**************/

IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Customer_Centre]') AND parent_object_id = OBJECT_ID(N'[dbo].[Customer]'))
ALTER TABLE [dbo].[Customer] DROP CONSTRAINT [FK_Customer_Centre]
GO

/****** Object:  Table [dbo].[Customer]    Script Date: 10/08/2013 13:33:54 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Customer]') AND type in (N'U'))
DROP TABLE [dbo].[Customer]
GO

/****** Object:  Table [dbo].[Customer]    Script Date: 10/08/2013 13:33:54 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Customer](
	[cusID] [int] NOT NULL,
	[first_name] [varchar](50) NOT NULL,
	[middle_name] [varchar](50) NULL,
	[last_name] [varchar](50) NOT NULL,
	[dob] [date] NOT NULL,
	[gender] [bit] NOT NULL,
	[contact_detail] [varchar](100) NULL,
	[email] [varchar](50) NULL,
	[address] [varchar](200) NULL,
	[education] [varchar](200) NULL,
	[occupation] [varchar](200) NULL,
	[married] [bit] NULL,
	[address_proof] [bit] NULL,
	[citizen_proof] [varchar](200) NULL,
	[health] [varchar](100) NULL,
	[centreID] [int] NOT NULL,
	[UICode] [varchar](50) NULL,
	[thumb] [bit] NULL,
	[fingerprint] [bit] NULL,
	[retina_scan] [bit] NULL,
	[status] [int] NULL,
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

ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Centre] FOREIGN KEY([centreID])
REFERENCES [dbo].[Centre] ([centreID])
GO

ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Centre]
GO




