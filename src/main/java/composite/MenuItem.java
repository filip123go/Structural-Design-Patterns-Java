package composite;

public class MenuItem extends MenuComponent {

	public MenuItem(String name, String url) {
		this.name = name;
		this.url = url;
	}

	@Override
	public java.lang.String toString() {
		return  print(this);
	}
}
