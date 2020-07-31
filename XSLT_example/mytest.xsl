<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:apply-templates select="//root/table"/>	
	<xsl:template match="table">
		<xsl:variable name="familynamevar" select="family/text()"/>
		<xsl:for-each select="row[not(surname/text()=preceding-sibling::row/surname/text())]">
			<xsl:variable name="surnamevar" select="surname/text()"/>
			<xsl:call-template name="family-surname">
				<xsl:with-param name="familynamevar" select="$familynamevar"/>
				<xsl:with-param name="surnamevar" select="$surnamevar"/>
			</xsl:call-template>
		</xsl:for-each>
	</xsl:template>	
	<xsl:template name="family-surname">
		<xsl:param name="familynamevar"/>
		<xsl:param name="surnamevar"/>	
			<table border="1" width="100%">
					<tr>
						<td colspan="3">
							<B>
								<xsl:value-of select="$familynamevar" /> -  <xsl:value-of select="$surnamevar" />
							</B>
						</td>
					</tr>			
					<xsl:for-each select="//root/table[family/text() = $familynamevar]/row[surname/text()=$surnamevar]">		
					
								<tr>
									<td width ="10%">
										<xsl:value-of select="title/text()" />
									</td>
									<td width ="40%">
										<xsl:value-of select="forename/text()" />
									</td>
									<td width ="50%">
										<xsl:value-of select="surname/text()" />
									</td>
								</tr>
					
					</xsl:for-each>					
				</table>
		<br/>
	</xsl:template>	
</xsl:stylesheet>
