package ProductManagement; // �ѱ۷� ��ǰ����

import java.io.IOException;

public class Store { // �ѱ�� �԰�
	/*
		���� status
	- inputStore method �ۼ���.
	- searchStore method �ۼ� �ʿ�.
	- saveStore method�� File I/O class �ϼ� ������ �ۼ� ���
	*/
	
	private int storePrice;
	private int storeAmount;
	private String storeDate;
	private String storeName;
	private String storeCode;
	private String storeClient;
	
	public Store() {
		this.storePrice = 0;
		this.storeAmount = 0;
		this.storeDate = null;
		this.storeName = null;
		this.storeCode = null;
		this.storeClient = null;
	}
	
	/*
	public Store() {
		this.storePrice = 10;
		this.storeAmount = 100;
		this.storeDate = "2017-12-25";
		this.storeName = "Samsung Galaxy Note 8";
		this.storeCode = "12345678901231";
		this.storeClient = "Samsung Electronics";
	}
	*/
	public void setPrice(int Price) {
		this.storePrice = Price;
	}
	
	public void setAmount(int Amount) {
		this.storeAmount = Amount;
	}
	
	public void setDate(String Date) {
		this.storeDate = new String(Date);
	}
	
	public void setName(String Name) {
		this.storeName = new String(Name);
	}
	
	public void setCode(String Code) {
		// ���ڵ� ��ȣ�� �Է¹޾Ƽ� ��ǰ��ȣ�� ��ȯ��Ų��.
		// �̸� ���ؼ�, ��ǰ����� �о ���� ������ ���ڸ� �ο��Ѵ�.
		this.storeCode = new String(Code);
	}
	
	public void setClient(String Client) {
		this.storeClient = new String(Client);
	}
	
	public int getPrice() {
		return this.storePrice;
	}
	
	public int getAmount() {
		return this.storeAmount;
	}
	
	public String getDate() {
		return new String(this.storeDate);
	}
	
	public String getName() {
		return new String(this.storeName);
	}
	
	public String getCode() {
		return new String(this.storeCode);
	}
	
	public String getClient() {
		return new String(this.storeClient);
	}
	
	public void inputStore(String ExpirationDate, String Container, int OriginalPrice, int Inadequate) {
		// Eclipse �ܼ� â���� �ǽ��ϸ� �ѱ� �Է� �� ������ �ֽ��ϴ�. �Է��� �� curser�� �������� �����ؾ���� �ؿ�(...)
		// UI �������� ��, �Է°��� �޾Ƽ� ��ȯ�޴� ����� ����ϴ°� ���� ��. Switch ������ ���� ��������.
		Product MadeProduct = new Product(ExpirationDate, Container, OriginalPrice, Inadequate); // �����ڸ� ���� ��ǰ ���� ���� �� ����ȴ�.
		MadeProduct.updateProductList(this, -1, -1); // ���� ������Ʈ
		saveStore(this); // �� ������ �κп� �ǽ�
	}
	
	public void searchStore() {
		
	}
	
	public int returnTotalStoreAmount() {
		int TotalAmount = -1;
		return TotalAmount;
	}
	
	private void saveStore(Store Input) { // ������ class�� file�� ����
		System.out.println("�� method�� �԰� ������ file�� �����ŵ�ϴ�.");
		System.out.println("Name: " + Input.getName());
		System.out.println("Amount: " + Input.getAmount());
		System.out.println("Date: " + Input.getDate());
		System.out.println("Price: " + Input.getPrice());
		System.out.println("Code: " + Input.getCode());
		System.out.println("Client: " + Input.getClient());
	}
}
