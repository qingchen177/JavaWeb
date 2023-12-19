package basic.reflect.inner;

import basic.reflect.inner.entity.MyPartInnerObject;

/**
 * @author qingchen
 * @date 31/10/2023 上午 11:11
 */

public class InnerDemo {
    public static void main(String[] args) {
//        静态内部类
//        MyStaticInnerObject myStaticInnerObject = new MyStaticInnerObject();
//        MyStaticInnerObject.InnerObject innerObject =new MyStaticInnerObject.InnerObject();
//
////        成员内部类
//        MyMemberInnerObject.MemberInnerObject memberInnerObject = new MyMemberInnerObject().new MemberInnerObject();
//        memberInnerObject.show();

//        局部内部类
        MyPartInnerObject myPartInnerObject = new MyPartInnerObject();
        myPartInnerObject.m2();
        myPartInnerObject.m3();

//        匿名内部类
//        MyAnonymousInnerObject myAnonymousInnerObject = new MyAnonymousInnerObject();
//        AnonymousInterface myAnonymousInterface = new AnonymousInterface(){
//            /**
//             * sayName
//             */
//            @Override
//            public void sayName() {
//                System.out.println("匿名内部类！");
//            }
//        };
//        myAnonymousInnerObject.m1(myAnonymousInterface);
//
//        ArrayList myList = new MyList();
//        myList.add(myAnonymousInnerObject);
    }
}
