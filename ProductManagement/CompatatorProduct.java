package ProductManagement;

import java.util.Comparator;
public class CompatatorProduct implements Comparator<Product>{
	public int compare(Product o1, Product o2) {
		String t1, t2;
		int returnValue = 0;
		t1 = o1.getBarCode();
		t2 = o2.getBarCode();
		if(t1.compareTo(t2) == 0) { // ���� ���ڿ�
			returnValue = 0;
		} else if(t1.compareTo(t2) < 0) { // ���������� ��
			returnValue = -1;
		} else if(t1.compareTo(t2) > 0) { // ���������� ��
			returnValue = 1;
		}
		return returnValue;
	}
}
