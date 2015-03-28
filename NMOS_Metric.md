No cálculo da métrica NMOS, o JaBUTi calcula o número de métodos sobrescritos na subclasse, através da contagem do número de métodos definidos na subclasse com o mesmo nome e a mesma assinatura de um método na sua superclasse. Os Construtores e inicializadores estáticos não são considerados.

A forma de cálculo desta métrica não toma em conta a ocultação (shadowing) de métodos que pode acontecer como no exemplo a baixo:

```
public class SuperClassA {
	
	private void method1(){
		System.out.println("Method1 SuperClass");
	}
	
	public void printMessage(){
		method1();
	}
	
}
```

```
public class SubClassB extends SuperClassA {
	
	
	public void method1(){
		System.out.println("Method1 SubClass");
	}

	protected int method2(int b){
		method1();
		return b;
	}
	
}
```

```
        SubClassB sub = new SubClassB();
        sub.printMessage();
	sub.method2(3);
```

O resultado é:

```
Method1 SuperClass
```

se mudamos o method 1 do código da SuperClassA por:
```
	public void method1(){
		System.out.println("Method1 SuperClass");
	}
```

O resultado é:

```
Method1 SubClass
```


---


Overload = Sobrecarga

Override = Sobrescrita

Overload acontece quando dois ou mais métodos com nomes iguais e parâmetros diferentes são utilizados. A resolução é feita em tempo de compilação.

Override acontece quando um método em uma classe filha substitui um método da classe pai. A resolução é feita em tempo de execução.

Fonte
http://pt.wikipedia.org/wiki/Orientação_a_objetos
http://en.wikipedia.org/wiki/Method_overloading