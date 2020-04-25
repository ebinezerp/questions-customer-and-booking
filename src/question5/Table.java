package question5;

public class Table implements Comparable<Table> {

	private Long id;
	private Integer number;
	private Integer capacity;

	public Table() {
		super();
	}

	public Table(Long id, Integer number, Integer capacity) {
		super();
		this.id = id;
		this.number = number;
		this.capacity = capacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return String.format("Table [id=%s, number=%s, capacity=%s]", id, number, capacity);
	}

	@Override
	public int compareTo(Table o) {
		return this.number.compareTo(o.number);
	}

	public static Table createTable(String line) {
		String[] details = line.split(",");
		Table table = new Table(Long.valueOf(details[0]), Integer.valueOf(details[1]), Integer.valueOf(details[2]));
		return table;
	}

}
