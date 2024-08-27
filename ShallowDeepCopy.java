package LeetCode;

public class ShallowDeepCopy {
    
    public static void main(String[] args) {
        
        // Reference copy
        // only copy the address of the obj
        Person p1 = new Person(18);
        Person p2 = p1;
        p2.age = 20;
        // p1 and p2 pointing to same object, change p2 will also change p1
        
        // Object copy
        // 1 - Shallow Copy
        Person p11 = new Person(18);
        Person p22 = p11.clone();
        p22.age = 20;
        // p22 change will not change p11
        
        // Object copy
        // 2 - Deep Copy
        // if the copied object contains Object reference
        PersonWithObject p111 = new PersonWithObject(18);
        PersonWithObject p222 = p111.clone();
        p222.age = 20;
        // p22 change will not change p11
    }
}

class Person implements Cloneable {
    int age;
    
    Person(int age) {
        this.age = age;
    }
    
    // Object copy
    // 1 - Shallow Copy
    @Override
    protected Person clone() {
        // this is protected method, unless it's overridden by sub class method
        // otherwise it's not accessible
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

class PersonWithObject implements Cloneable {
    int age;
    int[] accounts;
    
    PersonWithObject(int age) {
        this.age = age;
    }
    
    // Object copy
    // 1 - Shallow Copy
    @Override
    protected PersonWithObject clone() {
        // this is protected method, unless it's overridden by sub class method
        // otherwise it's not accessible
        try {
            PersonWithObject personWithObject = (PersonWithObject) super.clone();
            personWithObject.accounts = this.accounts.clone();
            return (PersonWithObject) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}