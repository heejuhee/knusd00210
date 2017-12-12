package StockRecordIO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;
import ProductManagement.Product;
import ProductManagement.Store;
import ProductManagement.Deliver;

public class StoreDeliverIO {
	static public void main(String args[]) throws IOException, InterruptedException {
		StoreDeliverIO io = new StoreDeliverIO();
		io.StoreInput();
		io.DeliverInput();
	}

	public void StoreInput() throws IOException, InterruptedException {
		Store InputStore = new Store();
		Scanner Input = new Scanner(System.in);
		String StrTemp = null;
		int IntTemp = 0;
		String ExpirationDate = null;
		String Container = null;
		int OriginalPrice = 0;
		int Inadequate = 0;
		boolean InputCheck = true; // �Է°� ��ȿ�� ���� �� ���� Ȯ�ο�
		
		System.out.println("��ǰ �̸��� �Է����ֽʽÿ�");
		InputStore.setName(Input.nextLine());
		System.out.println("�ŷ�ó���� �Է����ֽʽÿ�");
		InputStore.setClient(Input.nextLine());
		System.out.println("â���̸� �Ǵ� ��ġ�� �Է����ֽʽÿ�");
		Container = new String(Input.nextLine());
		
		System.out.println("�԰����ڸ� �Է����ֽʽÿ�(yyyy-MM-dd)");
		StrTemp = Input.nextLine();
		while(checkDate(StrTemp) != true) {
			System.out.println("Invaild Format. yyyy-MM-dd�� ���缭 �ٽ� �Է����ֽʽÿ�.");
			StrTemp = Input.nextLine();
		}
		InputStore.setDate(StrTemp);
		
		System.out.println("���ڵ��ȣ�� �Է����ֽʽÿ�");
		StrTemp = Input.nextLine();
		try {
			Double.parseDouble(StrTemp);
			InputCheck = true;
		} catch (NumberFormatException e){
			InputCheck = false;
		}
		while(StrTemp.length() != 13 || !(InputCheck)) {
			System.out.println("Invaild Format. ���ڵ� ��ȣ ���̿� ���缭 ���ڷ� �ٽ� �Է����ֽʽÿ�.");
			StrTemp = Input.nextLine();
			try {
				Long.parseLong(StrTemp);
				InputCheck = true;
			} catch (NumberFormatException e){
				InputCheck = false;
			}
		}
		InputStore.setCode(StrTemp);
		
		System.out.println("��������� �Է����ֽʽÿ�(yyyy-MM-dd) (���� ��ǰ�̸� '0000-00-00'�� �Է����ֽʽÿ�)");
		StrTemp = Input.nextLine();
		while(checkDate(StrTemp) != true) {
			if(StrTemp.equals("0000-00-00"))
				break;
			System.out.println("Invaild Format. yyyy-MM-dd�� ���缭 �ٽ� �Է����ֽʽÿ�.");
			StrTemp = Input.nextLine();
		}
		ExpirationDate = new String(StrTemp);
		
		System.out.println("�ǸŰ����� �� ����(\\)�� �Է����ֽʽÿ�");
		try {
			IntTemp = Input.nextInt();
			InputCheck = true;
		} catch(InputMismatchException e) {
			InputCheck = false;
		}
		while(!(InputCheck) || IntTemp <= 0) {
			System.out.println("Invalid value. ������ �ٽ� �Է����ּ���");
			Input.nextLine();
			try {
				IntTemp = Input.nextInt();
				InputCheck = true;
			} catch(InputMismatchException e) {
				InputCheck = false;
			}
		}
		InputStore.setPrice(IntTemp);
		
		System.out.println("�԰� ������ �Է����ֽʽÿ�");
		try {
			IntTemp = Input.nextInt();
			InputCheck = true;
		} catch(InputMismatchException e) {
			InputCheck = false;
		}
		while(!(InputCheck) || IntTemp <= 0) {
			System.out.println("Invalid value. �������� �ٽ� �Է����ּ���");
			Input.nextLine();
			try {
				IntTemp = Input.nextInt();
				InputCheck = true;
			} catch(InputMismatchException e) {
				InputCheck = false;
			}
		}
		InputStore.setAmount(IntTemp);
		
		System.out.println("������ �� ����(\\)�� �Է����ֽʽÿ�");
		try {
			IntTemp = Input.nextInt();
			InputCheck = true;
		} catch(InputMismatchException e) {
			InputCheck = false;
		}
		while(!(InputCheck) || IntTemp <= 0) {
			System.out.println("Invalid value. ������ �ٽ� �Է����ּ���");
			Input.nextLine();
			try {
				IntTemp = Input.nextInt();
				InputCheck = true;
			} catch(InputMismatchException e) {
				InputCheck = false;
			}
		}
		OriginalPrice = IntTemp;
		
		System.out.println("�����˸� ���ط��� �Է����ֽʽÿ�");
		try {
			IntTemp = Input.nextInt();
			InputCheck = true;
		} catch(InputMismatchException e) {
			InputCheck = false;
		}
		while(!(InputCheck) || IntTemp < 0) {
			System.out.println("Invalid value. ���ط��� �ٽ� �Է����ּ���");
			Input.nextLine();
			try {
				IntTemp = Input.nextInt();
				InputCheck = true;
			} catch(InputMismatchException e) {
				InputCheck = false;
			}
		}
		Inadequate = IntTemp;
		Input.nextLine();
		
		InputCheck = checkStoreInput(InputStore, ExpirationDate, Container, OriginalPrice, Inadequate);
		if(!(InputCheck)) {
			// �ٽ� �Է¹޾Ƽ� Ȯ��
			while(!(InputCheck)) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println("��ǰ �̸��� �Է����ֽʽÿ�[" + InputStore.getName() + "]");
				InputStore.setName(Input.nextLine());
				System.out.println("�ŷ�ó���� �Է����ֽʽÿ�[" + InputStore.getClient() + "]");
				InputStore.setClient(Input.nextLine());
				System.out.println("â���̸� �Ǵ� ��ġ�� �Է����ֽʽÿ�[" + Container + "]");
				Container = new String(Input.nextLine());
				
				System.out.println("�԰����ڸ� �Է����ֽʽÿ�(yyyy-MM-dd)[" + InputStore.getDate() + "]");
				StrTemp = Input.nextLine();
				while(checkDate(StrTemp) != true) {
					System.out.println("Invaild Format. yyyy-MM-dd�� ���缭 �ٽ� �Է����ֽʽÿ�.");
					StrTemp = Input.nextLine();
				}
				InputStore.setDate(StrTemp);
				
				System.out.println("���ڵ��ȣ�� �Է����ֽʽÿ�[" + InputStore.getCode() + "]");
				StrTemp = Input.nextLine();
				try {
					Double.parseDouble(StrTemp);
					InputCheck = true;
				} catch (NumberFormatException e){
					InputCheck = false;
				}
				while(StrTemp.length() != 13 || !(InputCheck)) {
					System.out.println("Invaild Format. ���ڵ� ��ȣ ���̿� ���缭 ���ڷ� �ٽ� �Է����ֽʽÿ�.");
					StrTemp = Input.nextLine();
					try {
						Long.parseLong(StrTemp);
						InputCheck = true;
					} catch (NumberFormatException e){
						InputCheck = false;
					}
				}
				InputStore.setCode(StrTemp);
				
				System.out.println("��������� �Է����ֽʽÿ�(yyyy-MM-dd)[" + ExpirationDate + "]");
				StrTemp = Input.nextLine();
				while(checkDate(StrTemp) != true) {
					if(StrTemp.equals("0000-00-00"))
						break;
					System.out.println("Invaild Format. yyyy-MM-dd�� ���缭 �ٽ� �Է����ֽʽÿ�.");
					StrTemp = Input.nextLine();
				}
				ExpirationDate = new String(StrTemp);
				
				System.out.println("�ǸŰ����� �� ����(\\)�� �Է����ֽʽÿ�[" + InputStore.getPrice() + "]");
				try {
					IntTemp = Input.nextInt();
					InputCheck = true;
				} catch(InputMismatchException e) {
					InputCheck = false;
				}
				while(!(InputCheck) || IntTemp <= 0) {
					System.out.println("Invalid value. ������ �ٽ� �Է����ּ���");
					Input.nextLine();
					try {
						IntTemp = Input.nextInt();
						InputCheck = true;
					} catch(InputMismatchException e) {
						InputCheck = false;
					}
				}
				InputStore.setPrice(IntTemp);
				
				System.out.println("�԰� ������ �Է����ֽʽÿ�[" + InputStore.getAmount() + "]");
				try {
					IntTemp = Input.nextInt();
					InputCheck = true;
				} catch(InputMismatchException e) {
					InputCheck = false;
				}
				while(!(InputCheck) || IntTemp <= 0) {
					System.out.println("Invalid value. �������� �ٽ� �Է����ּ���");
					Input.nextLine();
					try {
						IntTemp = Input.nextInt();
						InputCheck = true;
					} catch(InputMismatchException e) {
						InputCheck = false;
					}
				}
				InputStore.setAmount(IntTemp);
				
				System.out.println("������ �� ����(\\)�� �Է����ֽʽÿ�[" + OriginalPrice + "]");
				try {
					IntTemp = Input.nextInt();
					InputCheck = true;
				} catch(InputMismatchException e) {
					InputCheck = false;
				}
				while(!(InputCheck) || IntTemp <= 0) {
					System.out.println("Invalid value. ������ �ٽ� �Է����ּ���");
					Input.nextLine();
					try {
						IntTemp = Input.nextInt();
						InputCheck = true;
					} catch(InputMismatchException e) {
						InputCheck = false;
					}
				}
				OriginalPrice = IntTemp;
				
				System.out.println("�����˸� ���ط��� �Է����ֽʽÿ�[" + Inadequate + "]");
				try {
					IntTemp = Input.nextInt();
					InputCheck = true;
				} catch(InputMismatchException e) {
					InputCheck = false;
				}
				while(!(InputCheck) || IntTemp < 0) {
					System.out.println("Invalid value. ���ط��� �ٽ� �Է����ּ���");
					Input.nextLine();
					try {
						IntTemp = Input.nextInt();
						InputCheck = true;
					} catch(InputMismatchException e) {
						InputCheck = false;
					}
				}
				Inadequate = IntTemp;
				Input.nextLine();
				
				InputCheck = checkStoreInput(InputStore, ExpirationDate, Container, OriginalPrice, Inadequate);
			}
		}
		// ���⿡������ �Է°� ���� �ǽ�
		InputStore.inputStore(ExpirationDate, Container, OriginalPrice, Inadequate);
	}

	
	public void DeliverInput() throws IOException, InterruptedException{
		Deliver InputDeliver = new Deliver();
		Scanner Input = new Scanner(System.in);
		String StrTemp = null;
		int IntTemp = 0;
		boolean InputCheck = true; // �Է°� ��ȿ�� ���� �� ���� Ȯ�ο�
		
		System.out.println("��ǰ �̸��� �Է����ֽʽÿ�");
		InputDeliver.setName(Input.nextLine());
		System.out.println("�ŷ�ó���� �Է����ֽʽÿ�");
		InputDeliver.setClient(Input.nextLine());
		
		System.out.println("������ڸ� �Է����ֽʽÿ�(yyyy-MM-dd)");
		StrTemp = Input.nextLine();
		while(checkDate(StrTemp) != true) {
			System.out.println("Invaild Format. yyyy-MM-dd�� ���缭 �ٽ� �Է����ֽʽÿ�.");
			StrTemp = Input.nextLine();
		}
		InputDeliver.setDate(StrTemp);
		
		System.out.println("��ǰ ��ȣ�� �Է����ֽʽÿ�");
		StrTemp = Input.nextLine();
		try {
			Double.parseDouble(StrTemp);
			InputCheck = true;
		} catch (NumberFormatException e){
			InputCheck = false;
		}
		while(StrTemp.length() <= 13 || !(InputCheck)) {
			System.out.println("Invaild Format. ��ǰ ��ȣ�� ���̿� ���缭 ���ڷ� �ٽ� �Է����ֽʽÿ�.");
			StrTemp = Input.nextLine();
			try {
				Long.parseLong(StrTemp);
				InputCheck = true;
			} catch (NumberFormatException e){
				InputCheck = false;
			}
		}
		InputDeliver.setCode(StrTemp);
		
		System.out.println("����� �� ����(\\)�� �Է����ֽʽÿ�");
		try {
			IntTemp = Input.nextInt();
			InputCheck = true;
		} catch(InputMismatchException e) {
			InputCheck = false;
		}
		while(!(InputCheck) || IntTemp <= 0) {
			System.out.println("Invalid value. ������ �ٽ� �Է����ּ���");
			Input.nextLine();
			try {
				IntTemp = Input.nextInt();
				InputCheck = true;
			} catch(InputMismatchException e) {
				InputCheck = false;
			}
		}
		InputDeliver.setPrice(IntTemp);
		
		System.out.println("��� ������ �Է����ֽʽÿ�");
		try {
			IntTemp = Input.nextInt();
			InputCheck = true;
		} catch(InputMismatchException e) {
			InputCheck = false;
		}
		while(!(InputCheck) || IntTemp <= 0) {
			System.out.println("Invalid value. �������� �ٽ� �Է����ּ���");
			Input.nextLine();
			try {
				IntTemp = Input.nextInt();
				InputCheck = true;
			} catch(InputMismatchException e) {
				InputCheck = false;
			}
		}
		InputDeliver.setAmount(IntTemp);
		Input.nextLine();

		InputCheck = checkDeliverInput(InputDeliver);
		if(!(InputCheck)) {
			// �ٽ� �Է¹޾Ƽ� Ȯ��
			while(!(InputCheck)) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println("��ǰ �̸��� �Է����ֽʽÿ�[" + InputDeliver.getName() + "]");
				InputDeliver.setName(Input.nextLine());
				System.out.println("�ŷ�ó���� �Է����ֽʽÿ�[" + InputDeliver.getClient() + "]");
				InputDeliver.setClient(Input.nextLine());
				
				System.out.println("������ڸ� �Է����ֽʽÿ�(yyyy-MM-dd)[" + InputDeliver.getDate() + "]");
				StrTemp = Input.nextLine();
				while(checkDate(StrTemp) != true) {
					System.out.println("Invaild Format. yyyy-MM-dd�� ���缭 �ٽ� �Է����ֽʽÿ�.");
					StrTemp = Input.nextLine();
				}
				InputDeliver.setDate(StrTemp);
				
				System.out.println("��ǰ ��ȣ�� �Է����ֽʽÿ�[" + InputDeliver.getCode() + "]");
				StrTemp = Input.nextLine();
				try {
					Double.parseDouble(StrTemp);
					InputCheck = true;
				} catch (NumberFormatException e){
					InputCheck = false;
				}
				while(StrTemp.length() <= 13 || !(InputCheck)) {
					System.out.println("Invaild Format. ��ǰ ��ȣ�� ���̿� ���缭 ���ڷ� �ٽ� �Է����ֽʽÿ�.");
					StrTemp = Input.nextLine();
					try {
						Long.parseLong(StrTemp);
						InputCheck = true;
					} catch (NumberFormatException e){
						InputCheck = false;
					}
				}
				InputDeliver.setCode(StrTemp);
				
				System.out.println("������� �� ����(\\)�� �Է����ֽʽÿ�[" + InputDeliver.getPrice() + "]");
				try {
					IntTemp = Input.nextInt();
					InputCheck = true;
				} catch(InputMismatchException e) {
					InputCheck = false;
				}
				while(!(InputCheck) || IntTemp <= 0) {
					System.out.println("Invalid value. ������ �ٽ� �Է����ּ���");
					Input.nextLine();
					try {
						IntTemp = Input.nextInt();
						InputCheck = true;
					} catch(InputMismatchException e) {
						InputCheck = false;
					}
				}
				InputDeliver.setPrice(IntTemp);
				
				System.out.println("��� ������ �Է����ֽʽÿ�[" + InputDeliver.getAmount() + "]");
				try {
					IntTemp = Input.nextInt();
					InputCheck = true;
				} catch(InputMismatchException e) {
					InputCheck = false;
				}
				while(!(InputCheck) || IntTemp <= 0) {
					System.out.println("Invalid value. �������� �ٽ� �Է����ּ���");
					Input.nextLine();
					try {
						IntTemp = Input.nextInt();
						InputCheck = true;
					} catch(InputMismatchException e) {
						InputCheck = false;
					}
				}
				InputDeliver.setAmount(IntTemp);
				Input.nextLine();
				
				InputCheck = checkDeliverInput(InputDeliver);
			}
		}
		// ��ǰ��ȣ Ȯ���ؼ� ��ǰ ������ �ݿ����ϰ� ����
		// �ƴϸ� �ݿ�
	}
	
	private boolean checkDate(String CheckDate) {
		SimpleDateFormat DateFormat = new SimpleDateFormat();
		Date Date = new Date();
		// System.out.println(CheckDate);
		DateFormat.applyPattern("yyyy-MM-dd");
		DateFormat.setLenient(false);
	
		try {
			Date = DateFormat.parse(CheckDate);
		} catch(ParseException e) {
			// System.out.println("false");
			return false;
		}
		// System.out.println("true");
		return true;
	}
	
	private boolean checkStoreInput(Store InputStore, String ExpirationDate, String Container, int OriginalPrice, int Inadequate) throws IOException, InterruptedException {
		char yn, temp;
		boolean returnValue = true;
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		System.out.println("�Է��Ͻ� �԰� ����Դϴ�.");
		System.out.println("��ǰ�̸�: " + InputStore.getName());
		System.out.println("�԰�: " + InputStore.getAmount());
		System.out.println("�԰�����: " + InputStore.getDate());
		System.out.println("�԰�: " + InputStore.getPrice());
		System.out.println("���ڵ��ȣ: " + InputStore.getCode());
		System.out.println("�ŷ�ó: " + InputStore.getClient());
		System.out.println("�������: " + ExpirationDate);
		System.out.println("â����ġ: " + Container);
		System.out.println("����: " + OriginalPrice);
		System.out.println("�����˸� ���ط�: " + Inadequate);
		System.out.print("���� �Է��� �½��ϱ�(y/n)? ");
		yn = (char) System.in.read();
		do {
			temp = (char) System.in.read();
		}while(temp != '\n');
		
		if(!(yn == 'y' || yn == 'n' || yn == 'Y' || yn == 'N')) {
			while (!(yn == 'y' || yn == 'n' || yn == 'Y' || yn == 'N')) { // y�� n�� �ƴϸ� ���� Ȯ��
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println("temp : " + temp + ", yn : " + yn);
				System.out.println("�Է��Ͻ� �԰� ����Դϴ�.");
				System.out.println("��ǰ�̸�: " + InputStore.getName());
				System.out.println("�԰�: " + InputStore.getAmount());
				System.out.println("�԰�����: " + InputStore.getDate());
				System.out.println("�԰�: " + InputStore.getPrice());
				System.out.println("���ڵ��ȣ: " + InputStore.getCode());
				System.out.println("�ŷ�ó: " + InputStore.getClient());
				System.out.println("�������: " + ExpirationDate);
				System.out.println("â����ġ: " + Container);
				System.out.println("����: " + OriginalPrice);
				System.out.println("�����˸� ���ط�: " + Inadequate);
				System.out.print("���� �Է��� �½��ϱ�(y/n)? ");
				yn = (char)System.in.read();
				do {
					temp = (char) System.in.read();
				}while(temp != '\n');
			}
		}

		System.out.println("temp : " + temp + ", yn : " + yn);
		if(yn == 'y' || yn == 'Y')
			returnValue = true;
		else if(yn == 'n' || yn == 'N')
			returnValue = false;
		else {
			System.err.println("�԰��� Ȯ�� ����. �ý����� ��������ֽʽÿ�.");
			System.exit(1);
		}
		return returnValue;
	}
	
	private boolean checkDeliverInput(Deliver InputStore) throws IOException, InterruptedException {
		char yn, temp;
		boolean returnValue = true;
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		System.out.println("�Է��Ͻ� ��� ����Դϴ�.");
		System.out.println("��ǰ�̸�: " + InputStore.getName());
		System.out.println("���: " + InputStore.getAmount());
		System.out.println("�������: " + InputStore.getDate());
		System.out.println("���: " + InputStore.getPrice());
		System.out.println("��ǰ��ȣ: " + InputStore.getCode());
		System.out.println("�ŷ�ó: " + InputStore.getClient());
		System.out.print("���� �Է��� �½��ϱ�(y/n)? ");
		yn = (char)System.in.read();
		do {
			temp = (char) System.in.read();
		}while(temp != '\n');
		
		if(!(yn == 'y' || yn == 'n' || yn == 'Y' || yn == 'N')) {
			while (!(yn == 'y' || yn == 'n' || yn == 'Y' || yn == 'N')) { // y�� n�� �ƴϸ� ���� Ȯ��
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println("�Է��Ͻ� ��� ����Դϴ�.");
				System.out.println("��ǰ�̸�: " + InputStore.getName());
				System.out.println("���: " + InputStore.getAmount());
				System.out.println("�������: " + InputStore.getDate());
				System.out.println("���: " + InputStore.getPrice());
				System.out.println("��ǰ��ȣ: " + InputStore.getCode());
				System.out.println("�ŷ�ó: " + InputStore.getClient());
				System.out.print("���� �Է��� �½��ϱ�(y/n)? ");
				yn = (char)System.in.read();
				do {
					temp = (char) System.in.read();
				}while(temp != '\n');
			}
		}

		if(yn == 'y' || yn == 'Y')
			returnValue = true;
		else if(yn == 'n' || yn == 'N')
			returnValue = false;
		else {
			System.err.println("����� Ȯ�� ����. �ý����� ��������ֽʽÿ�.");
			System.exit(1);
		}
		return returnValue;
	}
}
