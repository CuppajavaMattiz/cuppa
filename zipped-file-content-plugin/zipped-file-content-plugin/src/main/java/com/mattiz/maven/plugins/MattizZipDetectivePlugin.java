package com.mattiz.maven.plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * @goal explore
 * 
 * @phase process-sources
 */
public class MattizZipDetectivePlugin extends AbstractMojo {
	/**
	 * Location of the file.
	 * 
	 * @parameter expression="${project.build.directory}"
	 * @required
	 */
	public void execute() throws MojoExecutionException {
		try {
			listFiles(new File(
					"."+File.separator+"package_holder"+File.separator+"Mattiz.zip"));
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listFiles(File zippedFile) throws ZipException, IOException {
		ZipFile zipFile = new ZipFile(zippedFile);
		try {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				File file = new File(entry.getName());
				System.out.println(file.getCanonicalPath());
			}
		} finally {
			zipFile.close();
		}
	}
}
