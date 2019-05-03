package model.vo;

public class Member {

	private static String id;
	private static String password;
	private static String name;
	private static String hp;
	private static int coins;

	public Member() {

	}

	public static String getId() {
		return id;
	}

	public Member setId(String id) {
		Member.id = id;
		return this;
	}

	public static String getPassword() {
		return password;
	}

	public Member setPassword(String password) {
		Member.password = password;
		return this;
	}

	public static String getName() {
		return name;
	}

	public Member setName(String name) {
		Member.name = name;
		return this;
	}

	public static String getHp() {
		return hp;
	}

	public Member setHp(String hp) {
		Member.hp = hp;
		return this;
	}

	public static int getCoins() {
		return coins;
	}

	public Member setCoins(int coins) {
		Member.coins = coins;
		return this;
	}

	public Member(String id, String password, String name, String hp, int coins) {
		super();
		Member.id = id;
		Member.password = password;
		Member.name = name;
		Member.hp = hp;
		Member.coins = coins;
	}

	public Member clone() {
		Member m = new Member();
		Member.id = Member.id;
		Member.password = Member.password;
		Member.name = Member.name;
		Member.hp = Member.hp;
		Member.coins = Member.coins;
		return m;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", hp=" + hp + ", coins=" + coins
				+ "]";
	}

}
