package com.egeo.utils.io;

import java.io.IOException;

public class FileUtilImpl extends FileUtil {

	public void write(String data) throws IOException {
		initWriter();
		writer.write(data);
		writer.flush();
		close();
	}

	@Override
	public String readAll() {
		try {
			initReader();
			StringBuffer s = new StringBuffer();
			byte[] bs = new byte[1024];
			int r = in.read(bs);
			while (r != -1) {
				String str = new String(bs);
				s.append(str);
				r = in.read(bs);
			}
			return s.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String readLine() {
		try {
			initReader();
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	FileUtilImpl(String filePath, String charset, boolean append) throws IOException{
		super(filePath, charset, append);
	}
}
