# 学んだこと

## Java での引数でのデータの渡され方

いただいたコメントの中に Java の引数はコピーされるのか参照が渡されるのかというものがあって、「参照が渡されるからコピーはされない」という答えは自分でもっていたが改めて調べてみると自分の認識と違う部分もあったので以下に記載します。

### そもそも参照渡しとは

オブジェクトの参照値（ポインタ）を渡す。実引数と仮引数が一致するので、呼び出し先で値を変えると呼び出し元の値も変更される。

ex1)

```
void updatePerson(Person &p) {
    p.name = "John";
    p.age = 25;
}

int main() {
    Person person = {"Alice", 30};

    std::cout << "変更前: " << person.name << ", " << person.age << std::endl;
    // 出力: 変更前: Alice, 30

    updatePerson(person);  // 参照渡しなので `person` の内容が変更される

    std::cout << "変更後: " << person.name << ", " << person.age << std::endl;
    // 出力: 変更後: John, 25
}
```

ex2)

```
void updatePerson(Person* &p) {
    p = new Person{"John", 25};  // `p` の参照先を新しいオブジェクトに変更。main側のpersonも新しいオブジェクトにかわる
}

int main() {
    Person* person = new Person{"Alice", 30};

    std::cout << "変更前: " << person->name << ", " << person->age << std::endl;
    // 出力: 変更前: Alice, 30

    updatePerson(person);  // `person` の参照先が新しいオブジェクトに変更される

    std::cout << "変更後: " << person->name << ", " << person->age << std::endl;
    // 出力: 変更後: John, 25

}

```

### Java では値渡ししかない

ややこしい部分として、Java では参照渡しっぽいことはできる。特に上記の ex1)については同様の動きになる。

ex1')

```
    public static void updatePerson(Person p) {
        // 参照値は同じものを指しているのでpのフィールドは変更されるとmainでのPersonも同じく変更されている。
        p.name = "John";
        p.age = 25;
    }

    public static void main(String[] args) {
        // Personオブジェクトを作成
        Person person = new Person("Alice", 30);

        System.out.println("変更前: " + person.name + ", " + person.age);
        // 出力: 変更前: Alice, 30

        // Personオブジェクトを渡して値を変更
        updatePerson(person);

        System.out.println("変更後: " + person.name + ", " + person.age);
        // 出力: 変更後: John, 25
    }
```

これは、Java で参照型のもの（配列やオブジェクト）について引数で渡される時に、ポインタのコピーを渡しているだけ（参照の値渡し）であることによる。つまり、呼び出し先の関数での引数では新しいメモリアドレスに元の参照型のアドレスがコピーされるという動きになる。なので、下記のように呼び出し先で新しい参照を割り当てると、呼び出し元とは関係なくなる。

ex2')

```

    public static void updatePerson(Person p) {
        // 新しいオブジェクトを作成し、pに割り当てる
        p = new Person("John", 25);  // これはメソッド内でpが新しいオブジェクトを指すようになるだけ
    }

    public static void main(String[] args) {
        // Personオブジェクトを作成
        Person person = new Person("Alice", 30);

        System.out.println("変更前: " + person.name + ", " + person.age);
        // 出力: 変更前: Alice, 30

        // 新しいオブジェクトを渡しても、元のオブジェクトは変わらない
        updatePerson(person);

        System.out.println("変更後: " + person.name + ", " + person.age);
        // 出力: 変更後: Alice, 30 (変更されていない)
    }

```
