package java0113;

// �丮�� 
interface Chef {
   void cook();
}

class ChineseChef implements Chef {
   
   @Override
   public void cook() {
      System.out.println("�߽Ŀ丮");
      
   }
}

class JapaneseChef implements Chef{
      
   @Override
   public void cook() {
      System.out.println("�ϽĿ丮");
      
   }
}

class KoreanChef implements Chef{
   
   @Override
   public void cook() {
      System.out.println("�ѽĿ丮");
      
   }
}
   
// �Ĵ�
class Restaurant {

   private Chef chef;
   
   // ���԰���� �ʿ��� ��ü�� �ܺο��� ���޹޴� ��� 2���� : ������, setter
   
   public Restaurant(Chef chef) {
      this.chef = chef;
   }
   
   public void setChef (Chef chef) {
      this.chef = chef;
   }
   
   
   // �丮�� ��ü�� �̿��ؼ� �Ĵ� �޼ҵ� ����...
}





public class Ex2 {

   public static void main(String[] args) {
      // ��ü �������� ���� : �� ������ �������� ��� ����
      
      JapaneseChef japaneseChef = new JapaneseChef();
      
      Restaurant rest = new Restaurant(japaneseChef);
      
      KoreanChef koreanChef = new KoreanChef();
      
      rest.setChef(koreanChef);
   }

}