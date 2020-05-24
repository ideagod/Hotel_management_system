package check;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int width = 100;
		int height = 30;
		// 先获取画布对象
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 先获取画笔对象
		Graphics2D g = (Graphics2D) image.getGraphics();
		// 设置颜色
		g.setColor(Color.white);
		// 画一个实心的矩形
		g.fillRect(0, 0, width, height);
		// 画一个边框
		g.setColor(Color.black);
		g.drawRect(0, 0, width - 1, height - 1);
		// 准备数据
		String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		// 常用的汉字
		StringBuffer sb = new StringBuffer();
		// 随机获取4个字符
		Random random = new Random();
		g.setColor(Color.red);
		// 设置字体
		g.setFont(new Font("微软雅黑", Font.BOLD, 20));
		// 随机获取4个字符
		int x = 20;
		int y = 20;
		for (int i = 0; i < 4; i++) {

			// 完成旋转的效果
			/**
			 * double theta ：代表的是弧度 弧度 = 角度 * Math.PI / 180; 随机获取正负30之间的角度 =
			 * random.nextInt(60) - 30;
			 */
			// 随机获取正负30之间的角度
			int jiaodu = random.nextInt(60) - 30;
			double hudu = jiaodu * Math.PI / 180;
			// 画弧线
			g.rotate(hudu, x, y);

			int index = random.nextInt(words.length());
			char ch = words.charAt(index);
			// 画到画布上区
			g.drawString(ch + "", x, y);
			// 生成一个字符，转进去
			sb.append(ch);
			g.rotate(-hudu, x, y);
			x += 20;
		}
		System.out.println(sb.toString());
		// 把生成的验证码保存到session域对象中
		HttpSession session = request.getSession();
		// 向session的域中存入生成的验证码
		session.setAttribute("sesscode", sb.toString());

		// 画干扰线
		g.setColor(Color.blue);
		int x1, y1;
		for (int i = 0; i < 100; i++) {
			x1 = random.nextInt(width);
			y1 = random.nextInt(height);

			g.drawLine(x1, y1, x1, y1);
		}
		// 释放资源
		g.dispose();
		// 把图片输出到客户端
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
