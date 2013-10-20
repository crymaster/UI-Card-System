USE [uicard]
GO

/****** Object:  Table [dbo].[Draft]    Script Date: 10/20/2013 16:03:12 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Draft]') AND type in (N'U'))
DROP TABLE [dbo].[Draft]
GO

USE [uicard]
GO

/****** Object:  Table [dbo].[Draft]    Script Date: 10/20/2013 16:03:12 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Draft](
	[draftID] [int] IDENTITY(1,1) NOT NULL,
	[first_name] [varchar](50) NULL,
	[middle_name] [varchar](50) NULL,
	[last_name] [varchar](50) NULL,
	[dob] [date] NULL,
	[gender] [smallint] NULL,
	[contact_detail] [varchar](100) NULL,
	[email] [varchar](50) NULL,
	[address] [varchar](200) NULL,
	[education] [varchar](200) NULL,
	[occupation] [varchar](200) NULL,
	[married] [bit] NULL,
	[passport] [bit] NULL,
	[voter] [bit] NULL,
	[driving_license] [bit] NULL,
	[health] [varchar](200) NULL,
 CONSTRAINT [PK_Draft] PRIMARY KEY CLUSTERED 
(
	[draftID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

