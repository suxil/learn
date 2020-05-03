package com.learn.core.util;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.*;
import java.util.Base64;
import java.util.Iterator;

/**
 * 图片通用处理工具类
 * @author luxq
 * @version 1.0
 */
@Slf4j
public final class ImageUtils {

    private static final String FORMAT = "jpg";

    private ImageUtils() {
    }

    /**
     * 通过文件缓冲获取图像输入流
     *
     * @param bufferedImage
     * @return
     */
    public static ImageInputStream getImageReader(BufferedImage bufferedImage) {
        ImageInputStream imageInputStream = null;
        try {
            imageInputStream = ImageIO.createImageInputStream(new ByteArrayInputStream(imageToByte(bufferedImage)));
        } catch (IOException e) {
            log.error("getImageReader: " + e.getMessage());
        }
        return imageInputStream;
    }

    /**
     * 通过文件获取图像输入流
     *
     * @param file
     * @return
     */
    public static ImageInputStream getImageInputStream(File file) {
        ImageInputStream imageInputStream = null;
        try {
            imageInputStream = ImageIO.createImageInputStream(file);
        } catch (IOException e) {
            log.error("getImageInputStream: " + e.getMessage());
        }
        return imageInputStream;
    }

    /**
     * 通过文件路径获取图像输入流
     *
     * @param filePath
     * @return
     */
    public static ImageInputStream getImageInputStream(String filePath) {
        return getImageInputStream(new File(filePath));
    }

    /**
     * 通过字节流图像转换位缓冲图像
     *
     * @param inputStream
     * @return
     */
    public static BufferedImage getBufferedImage(InputStream inputStream) {
        try {
            return ImageIO.read(inputStream); // 读入文件
        } catch (IOException e) {
            log.error("getBufferedImage inputStream: " + e.getMessage());
        }
        return null;
    }

    /**
     * 通过字符流图像转换位缓冲图像
     *
     * @param imageReader
     * @return
     */
    public static BufferedImage getBufferedImage(ImageReader imageReader) {
        try {
            return ImageIO.read(ImageIO.createImageInputStream(imageReader.getInput()));
        } catch (IOException e) {
            log.error("getBufferedImage imageReader: " + e.getMessage());
        }
        return null;
    }

    /**
     * 通过文件获取缓冲图像
     *
     * @param file
     * @return
     */
    public static BufferedImage getBufferedImage(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            log.error("getBufferedImage file: " + e.getMessage());
        }
        return null;
    }

    /**
     * 通过文件路径获取缓冲图像
     *
     * @param filePath
     * @return
     */
    public static BufferedImage getBufferedImage(String filePath) {
        return getBufferedImage(new File(filePath));
    }

    /**
     * 初始化图像字符流
     *
     * @param format
     * @return
     */
    public static ImageReader initImageReader(String format) {
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(format);
        ImageReader imageReader = readers.next();
        return imageReader;
    }

    /**
     * 通过图片输入流获取图像字符流
     *
     * @param imageInputStream
     * @param format
     * @return
     */
    public static ImageReader getImageReader(ImageInputStream imageInputStream, String format) {
        // 读取图片文件
        ImageReader reader = initImageReader(format);
        reader.setInput(imageInputStream, true);
        return reader;
    }

    /**
     * 通过图像缓冲获取图像字符流
     *
     * @param bufferedImage
     * @param format
     * @return
     */
    public static ImageReader getImageReader(BufferedImage bufferedImage, String format) {
        // 获取图片流
        ImageInputStream imageInputStream = getImageReader(bufferedImage);
        return getImageReader(imageInputStream, format);
    }

    /**
     * 通过文件获取图像字符流
     *
     * @param file
     * @param format
     * @return
     */
    public static ImageReader getImageReader(File file, String format) {
        // 获取图片流
        ImageInputStream imageInputStream = getImageInputStream(file);
        return getImageReader(imageInputStream, format);
    }

    /**
     * 通过文件获取图像字符流
     *
     * @param file
     * @return
     */
    public static ImageReader getImageReader(File file) {
        return getImageReader(file, FORMAT);
    }

    /**
     * 通过文件获取图像字符流
     *
     * @param filePath
     * @param format
     * @return
     */
    public static ImageReader getImageReader(String filePath, String format) {
        return getImageReader(new File(filePath), format);
    }

    /**
     * 通过文件路径获取图像字符流
     *
     * @param filePath
     * @return
     */
    public static ImageReader getImageReader(String filePath) {
        return getImageReader(filePath, FORMAT);
    }

    /**
     * 获取图片的宽
     *
     * @param imageReader 源图片字符流
     * @return
     */
    public static int getImageWidth(ImageReader imageReader) {
        try {
            return imageReader.getWidth(0);
        } catch (IOException e) {
            return 0;
        }
    }

    /***
     * 获取图片的高
     * @param imageReader 源图片字符流
     * @return
     */
    public static int getImageHeight(ImageReader imageReader) {
        try {
            return imageReader.getHeight(0);
        } catch (IOException e) {
            return 0;
        }
    }

    /**
     * 获取图片的宽
     *
     * @param filePath 源图片路径
     * @return
     */
    public static int getImageWidth(String filePath) {
        ImageReader reader = getImageReader(filePath);
        return getImageWidth(reader);
    }

    /***
     * 获取图片的高
     * @param filePath 源图片路径
     * @return
     */
    public static int getImageHeight(String filePath) {
        ImageReader reader = getImageReader(filePath);
        return getImageHeight(reader);
    }

    /**
     * 先剪裁图片后旋转
     * @param inputStream 文件流:源图像地址
     * @param x            目标切片起点x坐标
     * @param y            目标切片起点y坐标
     * @param width            目标切片宽度
     * @param height            目标切片高度
     * @param rotate            目标切片旋转度
     * @return
     */
    public static BufferedImage cutAndRotate(InputStream inputStream, int x, int y, int width, int height, int rotate) {
        BufferedImage bufferedImage = cut(inputStream, x, y, width, height);
        return rotate(bufferedImage, rotate);
    }

    /**
     * 先旋转再剪裁图片
     * @param inputStream 文件流:源图像地址
     * @param x            目标切片起点x坐标
     * @param y            目标切片起点y坐标
     * @param width            目标切片宽度
     * @param height            目标切片高度
     * @param rotate            目标切片旋转度
     * @return
     */
    public static BufferedImage rotateAndCut(InputStream inputStream, int x, int y, int width, int height, int rotate) {
        BufferedImage bufferedImage = rotate(inputStream, rotate);
        return cut(bufferedImage, x, y, width, height);
    }

    /***
     * 转换图像格式
     * @param filePath 原图像地址
     * @param formatName   转换类型
     * @return
     */
    public static ImageWriter convert(String filePath, String formatName) {
        try {
            ImageReader imageReader = getImageReader(filePath);
            return ImageIO.getImageWriter(imageReader);
        } catch (Exception e) {
            return null;
        }
    }

    /***
     * 转换图像格式
     * @param imageReader 图像字符流
     * @return
     */
    public static byte[] convert(ImageReader imageReader) {
        try {
            BufferedImage bufferedImage = getBufferedImage(imageReader);
            return imageToByte(bufferedImage);
        } catch (Exception e) {
            return new byte[0];
        }
    }

    /**
     * 彩色转为黑白
     *
     * @param srcImageFile 源图像地址
     */
    public static final byte[] gray(String srcImageFile) {
        BufferedImage bufferedImage = getBufferedImage(srcImageFile);
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        bufferedImage = op.filter(bufferedImage, null);
        return imageToByte(bufferedImage);
    }

    /**
     * 给图片添加图片水印
     *
     * @param srcImageFile  源图像地址
     * @param pressImg      水印图片
     * @param x             修正值。 默认在中间
     * @param y             修正值。 默认在中间
     * @param alpha         透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
     */
    public static BufferedImage pressImage(String srcImageFile, String pressImg, int x, int y, float alpha) {
        BufferedImage bufferedImage = getBufferedImage(srcImageFile);
        return pressImage(bufferedImage, new File(pressImg), x, y, alpha);
    }

    /**
     * 给图片添加图片水印
     *
     * @param pressImg      水印图片
     * @param bufferedImage  源图像
     * @param x             修正值。 默认在中间
     * @param y             修正值。 默认在中间
     * @param alpha         透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
     */
    public static BufferedImage pressImage(BufferedImage bufferedImage, File pressImg, int x, int y, float alpha) {
        if (bufferedImage == null) {
            return null;
        }

        int width = bufferedImage.getWidth(); // 得到源图宽
        int height = bufferedImage.getHeight(); // 得到源图长

        // 水印文件
        BufferedImage srcBiao = getBufferedImage(pressImg);
        if (srcBiao == null) {
            return null;
        }

        int widethBiao = srcBiao.getWidth();
        int heightBiao = srcBiao.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(bufferedImage, 0, 0, width, height, null);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        graphics.drawImage(srcBiao, width - widethBiao - x, height - heightBiao - y, widethBiao, heightBiao, null);
        // 水印文件结束
        graphics.dispose();
        return image;
    }

    /**
     * 给图片添加文字水印
     *
     * @param srcImageFile  源图像地址
     * @param pressText     水印文字
     * @param color         水印的字体颜色
     * @param fontName      水印的字体名称
     * @param fontStyle     水印的字体样式
     * @param fontSize      水印的字体大小
     * @param x             修正值
     * @param y             修正值
     * @param alpha         透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
     */
    public static BufferedImage pressText(String srcImageFile, String pressText, Color color, String fontName,
                                          int fontStyle, int fontSize, int x, int y, float alpha) {
        BufferedImage bufferedImage = getBufferedImage(srcImageFile); // 读入文件
        return pressText(bufferedImage, pressText, color, fontName, fontStyle, fontSize, x, y, alpha);
    }

    /**
     * 给图片添加文字水印
     *
     * @param bufferedImage  源图像
     * @param pressText     水印文字
     * @param color         水印的字体颜色
     * @param fontName      水印的字体名称
     * @param fontStyle     水印的字体样式
     * @param fontSize      水印的字体大小
     * @param x             修正值
     * @param y             修正值
     * @param alpha         透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
     */
    public static BufferedImage pressText(BufferedImage bufferedImage, String pressText, Color color, String fontName, int fontStyle, int fontSize, int x, int y, float alpha) {
        return pressText(bufferedImage, pressText, color, new Font(fontName, fontStyle, fontSize), x, y, alpha);
    }

    /**
     * 给图片添加文字水印
     *
     * @param bufferedImage  源图像
     * @param pressText     水印文字
     * @param color         水印的字体颜色
     * @param font      水印的字体信息
     * @param x             修正值
     * @param y             修正值
     * @param alpha         透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
     */
    public static BufferedImage pressText(BufferedImage bufferedImage, String pressText, Color color, Font font, int x, int y, float alpha) {
        int width = bufferedImage.getWidth(); // 得到源图宽
        int height = bufferedImage.getHeight(); // 得到源图长
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(bufferedImage, 0, 0, width, height, null);
        graphics.setColor(color);
        graphics.setFont(font);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        // 在指定坐标绘制水印文字
        graphics.drawString(pressText, (width - (StringUtils.getLength(pressText) * font.getSize())) / 2 + x, (height - font.getSize()) / 2 + y);
        graphics.dispose();
        return image;
    }

    /**
     * 剪裁图片
     * @param inputStream
     * @param x  起点横坐标
     * @param y  纵坐标
     * @param width  长
     * @param height  高
     * @return
     */
    public static BufferedImage cut(InputStream inputStream, int x, int y, int width, int height) {
        BufferedImage bufferedImage = getBufferedImage(inputStream); // 读入文件
        return cut(bufferedImage, x, y, width, height);
    }

    /**
     * 裁剪图片
     * @param bufferedImage 图片缓冲
     * @param x  起点横坐标
     * @param y  纵坐标
     * @param width  宽
     * @param height  高
     * @return
     */
    public static BufferedImage cut(BufferedImage bufferedImage, int x, int y, int width, int height) {
        if (bufferedImage == null) {
            return null;
        }
        try {
            ImageReader reader = getImageReader(bufferedImage, FORMAT);
            ImageReadParam param = reader.getDefaultReadParam();
            // 定义一个矩形
            Rectangle rect = new Rectangle(Math.max(x, 0), Math.max(y, 0), width, height);
            // 提供一个 BufferedImage，将其用作解码像素数据的目标。
            param.setSourceRegion(rect);
            return reader.read(0, param);
        } catch (Exception e) {
            return null;
        }
    }

    /***
     * 按照比例缩放
     * @param filePath
     * @param scale 缩放比例
     * @return
     */
    public static BufferedImage scale(String filePath, double scale) {
        BufferedImage bufferedImage = getBufferedImage(filePath);
        return scale(bufferedImage, scale);
    }

    /***
     * 按照比例缩放
     * @param inputStream
     * @param scale 缩放比例
     * @return
     */
    public static BufferedImage scale(InputStream inputStream, double scale) {
        BufferedImage bufferedImage = getBufferedImage(inputStream);
        return scale(bufferedImage, scale);
    }

    /***
     * 按照比例缩放
     * @param bufferedImage
     * @param scale 缩放比例
     * @return
     */
    public static BufferedImage scale(BufferedImage bufferedImage, double scale) {
        if (bufferedImage == null) {
            return null;
        }
        int width = bufferedImage.getWidth(); // 得到源图宽
        int height = bufferedImage.getHeight(); // 得到源图长
        // 转换宽高比例
        double w = Double.parseDouble(String.valueOf(width)) * scale;
        double h = Double.parseDouble(String.valueOf(height)) * scale;
        width = (int) w;
        height = (int) h;
        // 缩放图像
        return scale(bufferedImage, width, height);
    }

    /**
     * 缩放图像，按照长宽缩放
     * @param filePath
     * @param width   变换后的宽度
     * @param height  变换后的高度
     * @param isRepair 比例不对称时，是否补白，true 补白;false 不补白
     * @return
     */
    public static byte[] scale(String filePath, int width, int height, boolean isRepair) {
        BufferedImage bufferedImage = getBufferedImage(filePath); // 读入文件
        bufferedImage = scale(bufferedImage, width, height, isRepair);
        //ImageIO.write(bufferedImage, "JPEG", new File(result));
        return imageToByte(bufferedImage);
    }

    /**
     * 缩放图像，按照长宽缩放
     * @param inputStream
     * @param width   变换后的宽度
     * @param height  变换后的高度
     * @param isRepair 比例不对称时，是否补白，true 补白;false 不补白
     * @return
     */
    public static BufferedImage scale(InputStream inputStream, int width, int height, boolean isRepair) {
        BufferedImage bufferedImage = getBufferedImage(inputStream);
        return scale(bufferedImage, width, height, isRepair);
    }

    /**
     * 缩放图片大小，透明不补白
     * @param bufferedImage 图片缓冲
     * @param width   变换后的宽度
     * @param height  变换后的高度
     * @return
     */
    public static BufferedImage scale(BufferedImage bufferedImage, int width, int height) {
        return scale(bufferedImage, width, height, false);
    }

	/**
	 * 缩放图片大小
	 * @param bufferedImage 图片缓冲
     * @param width   变换后的宽度
     * @param height  变换后的高度
	 * @param isRepair 透明是否补白，true 补白;false 不补白
	 * @return
	 */
	public static BufferedImage scale(BufferedImage bufferedImage, int width, int height, boolean isRepair) {
        if (bufferedImage == null) {
            return null;
        }
        double ratio = 0.0; // 缩放比例
        int srcWidth = bufferedImage.getWidth();   // 源图宽度
        int srcHeight = bufferedImage.getHeight();   // 源图高度
        @SuppressWarnings("static-access")
		Image imgTemp = bufferedImage.getScaledInstance(width, height, bufferedImage.SCALE_SMOOTH);
        // 计算比例
//        if ((srcHeight > height) || (srcWidth > width)) {
//            if (srcHeight > srcWidth) {
//                ratio = (new Integer(height)).doubleValue() / srcHeight;
//            } else {
//                ratio = (new Integer(width)).doubleValue() / srcWidth;
//            }
//            AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
//            imgTemp = op.filter(bufferedImage, null);
//        }
        if (isRepair) {//补白
            imgTemp = repair(imgTemp, width, height);
        }
        return toBufferedImage(imgTemp);
	}

    /**
     * 旋转图片到固定角度
     * @param inputStream 输入流
     * @param rotate 旋转角度
     * @return
     */
    public static BufferedImage rotate(InputStream inputStream, int rotate) {
        BufferedImage bufferedImage = getBufferedImage(inputStream);
        return rotate(bufferedImage, rotate);
    }

    /**
     * 旋转图片到固定角度
     * @param bufferedImage 图片缓冲
     * @param rotate 旋转角度
     * @return
     */
    public static BufferedImage rotate(BufferedImage bufferedImage, int rotate) {
        if (bufferedImage == null) {
            return null;
        }
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        // 创建矩形
        Rectangle rectDes = calcRotatedSize(new Rectangle(new Dimension(width, height)), Math.max(rotate, 0));
        // 创建图像缓冲
        BufferedImage resultImage = new BufferedImage(rectDes.width, rectDes.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = resultImage.createGraphics();
        graphics.setPaint(Color.WHITE);
        graphics.fillRect(0, 0, rectDes.width,  rectDes.height);
        // transform
        graphics.translate((rectDes.width - width) / 2, (rectDes.height - height) / 2);
        graphics.rotate(Math.toRadians(rotate), (double)width / 2, (double)height / 2);
        graphics.drawImage(bufferedImage, null, null);
        return resultImage;
    }

    /**
     * 旋转角度
     *
     * @param rectangle
     * @param angel
     * @return
     */
    public static Rectangle calcRotatedSize(Rectangle rectangle, int angel) {
        if (rectangle == null) {
            return null;
        }
        // 如果天使大于90度，我们需要做一些转换。
        if (angel >= 90) {
            if (angel / 90 % 2 == 1) {
                int temp = rectangle.height;
                rectangle.height = rectangle.width;
                rectangle.width = temp;
            }
            angel = angel % 90;
        }
        double r = Math.sqrt((double) rectangle.height * rectangle.height + rectangle.width * rectangle.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angelAlpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angelDaltaWidth = Math.atan((double) rectangle.height / rectangle.width);
        double angelDaltaHeight = Math.atan((double) rectangle.width / rectangle.height);

        int lenDaltaWidth = (int) (len * Math.cos(Math.PI - angelAlpha - angelDaltaWidth));
        int lenDaltaHeight = (int) (len * Math.cos(Math.PI - angelAlpha - angelDaltaHeight));
        int desWidth = rectangle.width + lenDaltaWidth * 2;
        int desHeight = rectangle.height + lenDaltaHeight * 2;
        return new Rectangle(new Dimension(desWidth, desHeight));
    }

    /**
     * 填充白色返回新图像
     * @param bufferedImage
     * @param x x坐标（左边距）
     * @param y y坐标（右边距）
     * @param w 宽度
     * @param h 高度
     * @return
     */
    public static BufferedImage whiteNew(BufferedImage bufferedImage, int x, int y, int w, int h) {
        BufferedImage image = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x, y, w, h);
        graphics.dispose();
        return image;
    }

    /**
     * 填充白色返回当前图像
     * @param bufferedImage
     * @param x x坐标（左边距）
     * @param y y坐标（右边距）
     * @param w 宽度
     * @param h 高度
     * @return
     */
    public static BufferedImage white(BufferedImage bufferedImage, int x, int y, int w, int h) {
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x, y, w, h);
        graphics.dispose();
        return bufferedImage;
    }

	/**
	 * 补白
	 * @param image
	 * @param height
	 * @param width
	 * @return
	 */
	public static Image repair(Image image, int width, int height) {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = bufferedImage.createGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, width, height);

		int h = image.getHeight(null);
		int w = image.getWidth(null);
		if (width == w) {
			int y = (height - image.getHeight(null)) / 2;
			graphics.drawImage(image, 0, y, w, h, Color.white, null);
		} else {
			int x = (width - image.getWidth(null)) / 2;
			graphics.drawImage(image, x, 0, w, h, Color.white, null);
		}
		graphics.dispose();
		return bufferedImage;
	}

	/**
	 * 将图片转为 byte 数组
	 * @param bi 图片缓冲
	 * @return
	 */
	public static byte[] imageToByte(BufferedImage bi) {
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();) {
	        // 写入输出流
	        ImageIO.write(bi, FORMAT, outputStream);
	        // 转为 byte 数组
	        return outputStream.toByteArray();
		} catch (Exception e) {
            log.error("imageToByte: " + e.getMessage());
		}
		return new byte[0];
	}

    /**
     * 将byte 数组转为 图片
     * @param bytes 字节数组
     * @return
     */
    public static BufferedImage byteToImage(byte[] bytes) {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);) {
            return getBufferedImage(inputStream);
        } catch (Exception e) {
            log.error("byteToImage: " + e.getMessage());
        }
        return null;
    }

    /**
     * 转换image为缓冲图像
     * @param image
     * @return
     */
    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage)image;
        }
        // 确保所有图像都已加载
        image = new ImageIcon(image).getImage();
        // 创建一个兼容的缓冲图像
        BufferedImage bufferedImage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            // 确定新缓冲图像的透明度类型
            int transparency = Transparency.OPAQUE;
            // 创建缓冲图像
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bufferedImage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
        } catch (HeadlessException e) {
            // 系统没有屏幕
        }
        if (bufferedImage == null) {
            // 使用默认颜色模型创建缓冲图像
            int type = BufferedImage.TYPE_INT_RGB;
            bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }
        // 将图像复制到缓冲图像
        Graphics graphics = bufferedImage.createGraphics();
        // 将图像绘制到缓冲图像上
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();
        return bufferedImage;
    }

    /**
     * 将图片缓冲写到磁盘目录
     * @param bufferedImage
     * @param targetPath
     * @return
     */
    public static boolean write(BufferedImage bufferedImage, String targetPath) {
        return write(bufferedImage, FORMAT, targetPath);
    }

    /**
     * 将图片缓冲写到磁盘目录
     * @param bufferedImage
     * @param format
     * @param targetPath
     * @return
     */
	public static boolean write(BufferedImage bufferedImage, String format, String targetPath) {
        try {
            ImageIO.write(bufferedImage, format, new File(targetPath));
            return true;
        } catch (IOException e) {
            log.error("write: " + e.getMessage());
            return false;
        }
    }

    /**
     * 编码jpg图片
     * @param filePath
     * @return
     */
    public static String encodeJpg(String filePath) {
        BufferedImage bufferedImage = getBufferedImage(filePath);
        return encodeJpg(bufferedImage);
    }

    /**
     * 编码jpg图片
     * @param bufferedImage
     * @return
     */
    public static String encodeJpg(BufferedImage bufferedImage) {
        byte[] bytes = imageToByte(bufferedImage);
        return encodeJpg(bytes);
    }

    /**
     * 编码jpg图片
     * @param bytes
     * @return
     */
    public static String encodeJpg(byte[] bytes) {
        return "data:image/jpg;base64," + Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 编码png图片
     * @param bytes
     * @return
     */
    public static String encodePng(byte[] bytes) {
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 编码图片
     * @param filePath
     * @return
     */
    public static String encode(String filePath) {
        BufferedImage bufferedImage = getBufferedImage(filePath);
        return encode(bufferedImage);
    }

    /**
     * 编码图片
     * @param bufferedImage
     * @return
     */
    public static String encode(BufferedImage bufferedImage) {
        byte[] bytes = imageToByte(bufferedImage);
        return encode(bytes);
    }

    /**
     * 通过encode编码文件
     * @param bytes
     * @return
     */
    public static String encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

}
