package com.example.user.testlistview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //建立Book物件b1,b2(擁有屬於自己的變數name和方法getName()
        Book b1 = new Book();
        Book b2 = new Book();
        Log.e("b1", b1.getName());//E/b1: sum
        Log.e("b2", b2.getName());//E/b2: sum
        Log.e("A.c1",A.c1());//E/A.c1: class method不需new就可以使用
        //
        A a = new A();
        Log.e("A.c2",a.c2());//E/A.c2: instance method需要new才可使用

        /**
         * 由於 a 是類別變數，只有一個儲存值，而這個值是共享的；b 則是實例變數，所以每個實例都有一個 b 的儲存值，而它們的值也可以不一樣。
         * 所以後來設定的setA會取代之前設定的setA
         * 而setB可以有不同的值存在
         */
        B obj = new B();
        B obj2 = new B();
        obj.setA(1);   //a=1
        obj.setB(20);  //b=20
        obj2.setA(2);  //a=2
        obj2.setB(30); //b=30
        Log.e("obj.setA(1)", String.valueOf(obj.getA())); //2
        Log.e("obj.setB(20)", String.valueOf(obj.getB())); //20
        Log.e("obj2.setA(2)", String.valueOf(obj2.getA()));//2
        Log.e("obj2.setB(30)", String.valueOf(obj2.getB()));//30

    }
    /**
     * 宣告名稱為Book的類別
     * 宣告Book類別的變數及方法
     *
     * 實例（instance）是由 new 所產生的某個類別的實作，也稱為物件（object）。一個 class 可以生成多個實例，而且每個實例都擁有一份自己的實例變數
     *
     * 類別變數或類別方法以 static 起始，他們在程式開始執行時即實質的存在，所以不需要產生實例，即可使用。
     * 類別變數在宣告時就會配置記憶體 不隨物件增加而增加
     * 實例變數或實例方法沒有 static 起始，他們一定要等到實例產生之後才有實質的存在，因此需要實例，才可以使用。
     * 實例變數在產生物件時才會配置記憶體 會隨物件增加而增加
     */

    //藉由呼叫實例方法將實例變數的值傳回並輸出的範例
    class Book{
        //name為實例變數
        String name = "sum";
        //getName為實例方法
        String getName(){
            return name;
        }
    }

    //Class Method 與 Instance Method 的差異
    static class A{
        static String c1(){
            return "class method不需new就可以使用";
        }
        String c2(){
            return "instance method需要new才可使用";
        }
    }

    //Class Variable 與 Instance Variable 的差異

    /**
     * 宣告名稱為B的類別及類別內的變數和方法
     * 類別變數 a 實例變數 b
     * 實例方法 getA() setA() getB() setB()
     */
    static class B{
        static int a = 0;
        int b = 5;

        int getA(){
            return a;
        }
        void setA(int value){
            a=value;
        }
        int getB(){
            return b;
        }
        void setB(int value){
           b=value;
        }

    }


}
