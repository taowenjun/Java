package cn.tao.producerandconsumer;

public class Data {
    private String id;
    private String data;
	public Data(String string, String string2) {
		this.id=string;
		this.data=string2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
