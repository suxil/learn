package io.github.suxil.core.util;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

@Slf4j
public final class FtpUtils {

	private static FtpUtils instance = null;
	private static FTPClient ftpClient = null;
	private static String cacheDir = "D:/cache/";// 缓存压缩图片
	private static String server = "192.168.137.128";
	private static int port = 21;
	private static String userName = "ftpuser";
	private static String userPassword = "ftpuser";
	private static final String PATH = "";
	public static final int BUFF_SIZE = 1024;
	public static final String ENCODE = "UTF-8";//GBK    UTF-8

	private FtpUtils() {
	}

	/**
	 * 获取实例
	 * @return
	 */
	public static FtpUtils getInstance() {
		if (instance == null) {
			instance = new FtpUtils();
		}

		ftpClient = new FTPClient();
		return instance;
	}

	/**
	 * ftp文件操作回调接口
	 */
	public interface FtpCallback {
		boolean doInFtp(boolean status) throws IOException;
	}

	/**
	 * ftp文件操作回调接口
	 */
	public interface FtpOperationCallback {
		InputStream doInFtp() throws IOException;
	}

	/**
	 * ftp文件操作基础方法
	 * @param action
	 * @return
	 */
	public boolean executor(FtpCallback action) {
		return executor("", action);
	}

	/**
	 * ftp文件操作基础方法
	 * @param action
	 * @return
	 */
	public boolean executor(String path, FtpCallback action) {
		boolean status = false;
		if (action != null) {
			try {
				cd(path);
				open();
				status = action.doInFtp(status);
			} catch (IOException e) {
				log.error("executor path action: " + e.getMessage());
			} finally {
				close();
			}
		}
		return status;
	}

	/**
	 * ftp目录操作模板方法，不打开连接
	 * @param action
	 * @return
	 */
	public boolean executorNotOpen(FtpCallback action) {
		boolean status = false;
		if (action != null) {
			try {
				status = action.doInFtp(status);
			} catch (IOException e) {
				log.error("executorNotOpen: " + e.getMessage());
			}
		}
		return status;
	}

	/**
	 * ftp文件操作基础方法
	 * @param action
	 * @return
	 */
	public boolean executor(FtpOperationCallback action) {
		boolean status = false;
		if (action != null) {
			try {
				open();
				action.doInFtp();
				status = true;
			} catch (IOException e) {
				log.error("executor action: " + e.getMessage());
			} finally {
				close();
			}
		}
		return status;
	}

	/**
	 * ftp文件操作基础方法
	 * @param action
	 * @return
	 */
	public InputStream executor(String path, FtpOperationCallback action) {
		InputStream input = null;
		if (action != null) {
			try {
				cd(path);
				open();
				input = action.doInFtp();
			} catch (IOException e) {
				log.error("executor path operation: " + e.getMessage());
			} finally {
				close();
			}
		}
		return input;
	}

	/**
	 * 连接FTP服务器
	 *
	 * @return
	 */
	private boolean connect() {
		boolean status = false;
		try {
			if (ftpClient.isConnected())
				return true;
			ftpClient.connect(server, port);
			status = true;
		} catch (SocketException e) {
			log.error("connect SocketException: " + e.getMessage());
		} catch (IOException e) {
			log.error("connect IOException: " + e.getMessage());
		}
		return status;
	}

	/**
	 * 打开FTP服务器
	 *
	 * @return
	 */
	public boolean open() {
		if (!connect()) {
			return false;
		}

		boolean status = false;
		try {
			status = ftpClient.login(userName, userPassword);
			// 检测连接是否成功
			int reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				close();
				status = false;
			}
		} catch (IOException e) {
			status = false;
		}
		return status;
	}

	/**
	 * 关闭FTP服务器
	 */
	public void close() {
		try {
			if (ftpClient != null) {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}

				ftpClient = null;
			}
		} catch (IOException e) {
		}
	}

	/**
	 * 上传文件到FTP服务器
	 *
	 * @param fileName
	 * @param filePath
	 * @return
	 */
	public boolean upload(String fileName, String filePath) {
		return upload(PATH, fileName, new File(filePath));
	}

	/**
	 * 上传文件到FTP服务器
	 *
	 * @param path
	 * @param fileName
	 * @param filePath
	 * @return
	 */
	public boolean upload(String path, String fileName, String filePath) {
		return upload(path, fileName, new File(filePath));
	}

	/**
	 * 上传文件到FTP服务器
	 *
	 * @param fileName
	 * @param file
	 * @return
	 */
	public boolean upload(String fileName, File file) {
		return upload(PATH, fileName, file);
	}

	/**
	 * 上传文件到FTP服务器
	 *
	 * @param path
	 * @param fileName
	 * @param file
	 * @return
	 */
	public boolean upload(String path, String fileName, File file) {
		boolean status = false;
		try {
			FileInputStream input = new FileInputStream(file);
			status = upload(path, fileName, input);
		} catch (IOException e) {
			log.error("upload: " + e.getMessage());
		}
		return status;
	}

	/**
	 * 上传文件到FTP服务器
	 *
	 * @param path
	 * @param fileName
	 * @param input
	 * @return
	 */
	public boolean upload(String path, String fileName, InputStream input) {
		return executor(path, (status) -> {
			ftpClient.setBufferSize(BUFF_SIZE);
			ftpClient.setControlEncoding(ENCODE);
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

			status = ftpClient.storeFile(fileName, input);

			return status;
		});
	}

	/**
	 * 上传图片自动压缩处理
	 *
	 * @param path
	 * @param fileName
	 * @param input
	 * @param quality
	 * @param maxWidth
	 * @param maxHeight
	 * @return
	 */
	public boolean uploadImage(String path, String fileName, InputStream input, float quality, int maxWidth, int maxHeight) {
		return executor(path, (status) -> {
			String suffex = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
			System.out.println(suffex);
			File imagePath = new File(cacheDir + fileName);
			Thumbnails.of(input).outputQuality(quality).size(maxWidth, maxHeight).toFile(imagePath);
			input.close();

			if (!imagePath.exists()) {
				return status;
			}

			ftpClient.setBufferSize(BUFF_SIZE);
			ftpClient.setControlEncoding(ENCODE);
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

			FileInputStream inputStream = new FileInputStream(imagePath);
			status = ftpClient.storeFile(fileName, inputStream);

			input.close();
			if (!imagePath.delete()) {
				log.warn("image path delete false.");
			}

			return status;
		});
	}

	/**
	 * 下载文件为file
	 *
	 * @param fileName
	 * @return
	 */
	public File downToFile(String fileName) {
		return downToFile(PATH, fileName, new File(fileName));
	}

	/**
	 * 下载文件为file
	 *
	 * @param path
	 * @param fileName
	 * @return
	 */
	public File downToFile(String path, String fileName) {
		return downToFile(path, fileName, new File(fileName));
	}

	/**
	 * 下载后拷贝到file
	 *
	 * @param fileName
	 * @param file
	 * @return
	 */
	public File downToFile(String fileName, File file) {
		return downToFile(PATH, fileName, file);
	}

	/**
	 * 下载后拷贝到file
	 *
	 * @param path
	 * @param fileName
	 * @param file
	 * @return
	 */
	public File downToFile(String path, String fileName, File file) {
		try {
			InputStream input = downToInputStream(path, fileName);
			FileUtils.copyToFile(input, file);
		} catch (IOException e) {
			log.error("downToFile: " + e.getMessage());
		}
		return file;
	}

	/**
	 * 下载文件为inputStream
	 *
	 * @param path
	 * @param fileName
	 * @return
	 */
	public InputStream downToInputStream(String path, String fileName) {
		return executor(path, () -> ftpClient.retrieveFileStream(fileName));
	}

	/**
	 * 循环切换目录
	 *
	 * @param dir
	 * @return
	 */
	public boolean cd(String dir) {
		return executorNotOpen((status) -> {
			String[] dirs = dir.split("/");
			if (dirs.length == 0) {
				return status;
			}

			for (String dirss : dirs) {
				ftpClient.changeWorkingDirectory(dirss);
			}
			status = true;
			return status;
		});
	}

	/***
	 * 创建目录
	 *
	 * @param dir
	 * @return
	 */
	public boolean mkdir(String dir) {
		return executor((status) -> {
			ftpClient.changeToParentDirectory();
			ftpClient.makeDirectory(dir);
			status = true;
			return status;
		});
	}

	/***
	 * 创建多个层级目录
	 *
	 * @param dir aaa/bbb/ccc
	 * @return
	 */
	public boolean mkdirs(String dir) {
		return executor((status) -> {
			String[] dirs = dir.split("/");
			if (dirs.length == 0) {
				return status;
			}

			for (String dirss : dirs) {
				ftpClient.makeDirectory(dirss);
				ftpClient.changeWorkingDirectory(dirss);
			}
			status = true;
			return status;
		});
	}

	/**
	 * 删除文件夹
	 *
	 * @param pathname
	 * @return
	 */
	public boolean rmdir(String pathname) {
		return executor((status) -> ftpClient.removeDirectory(pathname));
	}

	/**
	 * 删除文件
	 *
	 * @param pathname
	 * @return
	 */
	public boolean remove(String pathname) {
		return executor((status) -> ftpClient.deleteFile(pathname));
	}

	/**
	 * 移动文件或文件夹
	 *
	 * @param pathname1
	 * @param pathname2
	 * @return
	 */
	public boolean rename(String pathname1, String pathname2) {
		return executor((status) -> ftpClient.rename(pathname1, pathname2));
	}

}
