# [C++] 

- 학습 기간 : 2019.09.30 ~ 2019.10.04
- 개요
  - upgrade & new

## 1. Upgrade & New

------

### 1.1 C++의 구조체

1) c++의 구조체에서는 변수를 비롯해서 함수도 포함할 수 있다.

- 함수를 구조체 안에 포함시킴으로써 재사용 측면에서 더욱 합리적이다.

- 장점 : 함수 내에서 구조체를 사용할 때, 구조체의 인자를 생략 가능하다.

- 단점 : 가독성이 떨어진다. (예를 들어, const...  ---> 하지만 뒤에 함수 뒤에 생략 가능함)

- 다음과 같이 구조체 정의 안에 함수를 정의할 수 있다.

  ```c++
  #include <stdio.h>
  
  struct st{
  private:
  	int no;
  	char ch;
  public:
  	void InitStruct(int n, char c)
  	{
  		if (n % 2 == 0) n++;	//interface 코드
  		no = n;
  		ch = c;
  	}
  
  	// 읽기 위한 함수 --> const
  	void PrintStruct(void) const
  	{
  		printf("%d %c\n", no, ch);
  	}
  };
  ```

  또한, 읽기 전용(구조체 자체에 손상이 없음) 함수에는 const를 붙여서 명시화할 수 있다.

 

2) c++에서는 예약어 struct를 생략하는 선언 방식으로 구조체 변수의 선언을 일반화했다.

- 예약어 struct를 생략하고 구조체 이름만으로도 구조체 변수를 선언할 수 있다. 이 경우 st가 타입명이 된다.

  ```c++
  void main(void)
  {
  	/*struct*/ st aa;
  	printf("%d\n", sizeof(aa));
  	aa.InitStruct(5, 'A');
  	aa.PrintStruct();
  }
  ```

  모든 타입을 (c언어 문법에 관대한) '정수'처럼 일반화할 수 있다.

  구조체 이름 == 데이터 타입



3) c++ 구조체에서는 멤버에 접근하기 위한 접근권한 예약어(private, protected, public)을 사용할 수 있다.

- 접근 권한의 사용 예시

  ```c++
  	struct st{
  	private: // 구조체 외부에서 접근을 허용하지 않고 내부에서만 접근 허용
  		int no;
  	protected: // 구조체 외부에서 접근을 허용하지 않고 내부와 자식클래스에서 접근 허용
  		char ch;
  	public: // 구조체 외부에서 접근을 허용하는 구조체의 기본(default) 접근권한
  		int sum;
  		void sub(void); // 클래스 안에 선언
  	};
  
  	void st :: sub(void) // 외부에 정의
  	{ 
  		… 
  	}
  ```

- 접근 권한을 통해 코드 재사용 시, 잘못된 권한을 제한할 수 있다.

- 여기에서 **개체**란?

  **데이터의 저장과 저장된 데이터를 조작할 수 있는 함수들의 집합**

- 구조체와 클래스의 유일한 차이점은 기본 접근 권한이다.
  - 구조체 - public
  - 클래스 - private



------

### 1.2 출력 개체 cout

- cout 은 printf와 달리 형식 없이 출력이 가능하다!

1) cout은 **헤더파일 <iostream>에서 클래서 ostream으로 선언된 전역 개체**이다.

2) << 연산자를 이용해서 출력한다. (operator <<() 함수 중복 정의 / <<는 비트연산자이기도 함)

- 형식]  cout << 값1 << 값2 << ... 

  ```c++
  #include <iostream>
  using namespace std;
  
  void main(void)
  {
  	cout << "kim";	//printf("%s", "kim");
  	cout << 10 << " " << 3.14 << (int)'A' << endl;
  	cout << hex << 20 << endl;	// oct, dec
  	cout << hex << 20 << " " << 21;
  }
  ```

  위의 'hex' 는 계속 유지됨

- 연산자 중복정의(operator overloading)란?

  기존의 연산자 기능을 확장시킬 수 있다.

  ex) cout의 출력 개체 기능과 비트연산자 기능

- printf() 함수와 달리 형식 없이 출력이 가능하도록 설계한 이유는?

  어떤 타입도 반환할 수 있도록!



------

### 1.3 입력 개체 cin

1) cin은 헤더파일 <iostream>에서 클래스 istream으로 선언된 개체이다.

2) >> 연산자를 이용해서 입력 받는다. (operator >>() 함수 중복 정의)

- &(주소 연산자) 를 쓰지 않는다.

- 형식]  cin >> 변수1 >> 변수2 >> ...

  ```c++
  #include <iostream>
  using namespace std;
  
  void main(void)
  {
  	int num;
  	cout << "Input Decimal : ";
  	cin >> num; // scanf("%d", &num); // call by address
  	cout << "Hexa : " << hex << num << endl;
  	// 위의 hex가 계속 영향을 미침
  	cout << 20 << endl;
  	cout << dec << 20 << endl;
  }
  ```



- ```c++
  #include <iostream>
  using namespace std;
  
  void main(void)
  {
  	// compile 시간에 선언과 초기화가 완료! --> 배열 크기의 인자로 쓸 수 있음
  	const int n = 5;
  
  	// char 포인터로 선언하지 않도록 주의!
  	char name[20];
  	int age;
  	char addr[50];
  
  	cout << "Name:";
  	cin >> name;
    
  	cout << "Age:";
  	cin >> age; // scanf("%d", &age);
    
  	cout << "Addr:";
  	cin >> addr; // scanf("%[a-zA-Z0-9 ]s", addr);
    
  	cout << name << '\t' << age << '\t' << addr << endl;
    
  	// overflow검사까지 완료
  	cin.ignore();
  	cin.getline(addr, 20);
  	cout << addr << endl;
    
  	//gets(addr)	scanf("%[a-zA-Z0-9 ]s") --> 공백 받을 수 있음
  }
  ```



------

### 1.4 변수의 변화

1) c++에서는 변수가 **필요한 위치에서 자율적인 변수 선언**이 가능하다. 하지만 무분별한 다수의 위치에서의 변수 선언은 프로그램 분석을 난해하게 할 수 있다.

2) c++에서 새롭게 등장한 변수의 선언과 초기화식

- 중괄호 초기화 : 자료형 변수명(초기값);

- 괄호 초기화 :  자료형 변수명{초기값};

- ```c++
  	int n = 5;
  	int * p = &n;
  	const char * cstr = “seoul”;
  
  	// 괄호 초기화 
  	int k(10), j(7); 
  	int r = int(5);
  	const char * str("seoul");
  	char name[5]("kim");
  	// char names[][5]("kim", "park", "lee”); // 괄호(()) 초기화 불가
  
  	// 중괄호 초기화
  	char names[][5]{"kim", "park", "lee"}; 
  	int n{ 10 };
  	int k = int{ 5 };
  	const char * str{ "seoul" };
  	char name[5]{"kim"};
  
  	// 인수 전달과 리턴 시
  	int sub(int r) // int r = 5; // int r(5); // 인수전달 수식 == 선언과 동시에 초기화
  	{
  		return r; // int imsi = r; // int imsi(r); // 리턴 수식 == 선언과 동시에 초기화
  	}
  	…
  	sub(5);
  	sub(int(5));
  ```

3) for문에서의 변수 선언

```c++
	int array[] ={10, 20, 30, 40};

	for(int n = 0; n < 4; n++) // for문 블록({ }) 이후에서 변수 n은 사용불가(VS 6.0 허용)
	{
		cout << array[n];
	}

	for(int n : array) // 배열의 0번째 요소부터 순차적으로 순회하는 for문(현 위치에서 변수 선언 요함)
	{
		cout << n; 
	}

	const char * names[3] = { "kim", "park", "lee" };

	for (const char * irum : names) 
	{
		cout << irum;
	}
```



------

### 1.5 스코프(scope, ::) 연산자

1) 클래스나 구조체의 멤버함수를 외부에 정의할 때 소속 표현을 위해 사용한다.

- 형식] return형 클래스명 :: 멤버함수명(파라미터 선언, ...){}

  ```c++
  #include <stdio.h>
  
  struct st{
  private:
  	int no;
  	char ch;
  public:
  	void InitStruct(int n, char c);
  	void PrintStruct(void) const;
  };
  
  // 구조체 멤버함수를 전역에 정의
  void st::InitStruct(int n, char c)
  {
  	if (n % 2 == 0) n++;
  	no = n;
  	ch = c;
  }
  
  void st::PrintStruct(void) const
  {
  	printf("%d %c\n", no, ch);
  }
  
  void main(void)
  {
  	/*struct*/ st aa;
  	printf("%d\n", sizeof(aa));
  	aa.InitStruct(5, 'A');
  	aa.PrintStruct();
  }
  ```



2) 지역변수와 동일한 전역변수가 있을 때, 변수명 앞에 (::)를 붙여 지역변수와 구별되는 **전역변수의 접근**을 위해 사용한다.

- 형식] :: 변수명

  ```c++
  // 전역과 지역의 변수명이 동일한 경우, 지역이 우선
  #include <iostream>
  using namespace std;
  
  int no = 10;
  
  void main(void)
  {
  	int no = 5;
  	// :: 붙여주면, 전역 우선
  	// 지역에 no가 없더라도, 전역이라면 :: 붙여쓰는 습관을 들이자
  	cout << ::no << endl;
  }
  ```



3) 지역함수(멤버함수)의 이름과 동일한 **전역함수의 우선 호출**을 위해 사용한다.

```c++
	struct st{
		void sub(void) // 지역함수
		{
		}
		void func(void)
		{
			sub(); // 지역함수 호출
			::sub(); // 전역함수 호출
		}
	};

	void sub(void) // 전역함수
	{
	}
```



------

### 1.6 예약어 const

1) c언어에서도 const를 지원했지만, 읽기전용 변수로 만들어주는 예약어일뿐, 완벽히 상수의 기능을 갖도록 해주지는 못했다.

```c++
	// C언어의 경우
	const int n; // 초기값 오류 없음
	char str[n]; // 배열의 요소 개수로 사용불가
	int * p = &n;  // warning different 'const' qualifiers
	*p = 10; // 변경 가능
```



2) c++에서는 완벽히 상수화 시켜주는 예약어로 사용이 가능하다!

```c++
#include <stdio.h>

void main(void)
{
	const int n = 5;
	char str[n];   // 가능 (compile 시간에 n 대신 5 들어감)
	//n = 10;		--> 불가 
	//int *p = &n;		--> 불가 (&n의 자료형은 const int *)
	const int *p = &n;	//가능
	//*p = 10;		--> 불가(const는 수정 불가)

	int *q = (int *)&n;
	*q = 10;
	printf("%d\n", n); //5 출력		출력을 할 때, const int n에 처음에 저장된 값을 반환
	printf("%d\n", *p); //10 출력
}
```

- const를 사용하려면 초기값을 주어야 함! (하지만 초기값을 부여하지 않더라도 에러로 판단하지는 않음)

- const는 컴파일러의 선처리가 일어나, 런타임에 const 변수를 상수처럼 사용할 수 있다.

  모든 n에 5가 컴파일 시간에 대입된다.  (배열의 인자, ...)

- 하지만 volatile const int 로 선언하면, 컴파일러의 선처리가 일어나지 않기 때문에 값이 바뀌어 출력된다.

- n이 const이면, &n도 const *가 된다! nonconst로 형변환을 해주지 않으면, nonconst 변수에는 대입할 수 없다.

- *p를 출력했을 때, 값이 바뀌어져 있는 것을 보아, 값은 변경되었지만, compiler Time에 컴파일러에 의해 n은 자동으로 5가 출력이 된다.



3) **포인터에 예약어 const를 적극 사용**하자!

```c++
#include <stdio.h>
#include <iostream>
using namespace std;

void main(void)
{
	int n = 5, k = 6;

	// p가 가리키는 대상을 상수로 보겠다!!
	// 가리키는 대상의 상수 여부는 관계없음. 그냥 p로 읽기만 하겠다의 의미
	const int *p;
  
	// q를 상수로 보겠다! --> 초기값을 주어야 함 --> 주지 않으면 에러
	// q는 오로지 k만 바라봄 (다른 변수로 이동할 수 없음)
	int * const q = &k;

	p = &n;
	//*p = 10; //에러
	cout << *p << endl;
	
	*q = 100;
	//q = &n; // 에러
	cout << *q << endl;

	sub(&p);
	func(&q);
}

void sub(const int **pp)
{
}

void func(int * const *qq)
{
}
```

- **const int *p**

  p는? 포인터야! 뭐를 가리키니? const int를 가리키는 포인터야!

  const int 니까 *p의 값을 수정할 수 없겠구나!

- **int * const q** = &k; 

  q는? const포인터야! 뭐를 가리키니? int를 가리키는 포인터야! 

  const니까 초기값이 있어야겠네!! 또 오로지 k만 바라보겠네!

- **const int ******pp**= &p;

  pp는? 포인터야! 뭐를 가리키니? const int *인 &p를 가리켜!

- **int * const * qq** = &q;

  qq는? 포인터야! 뭐를 가리키니? int * const 형인 &q를 가리켜! 



```c++
#include <iostream>
using namespace std;

int *sub(void);
const int *sub1(void);

void main(void)
{
	//sub() = 9; // 에러
	*sub() = 0;
	sub();
}

int *sub(void)
{
	// static : 함수의 scope가 끝나도, n이 stack에 있지 않기 때문에, 읽을 수 있음
	static int n = 5;
	cout << n << endl;
	return &n;
}

// return형이 const인 경우, return 값을 변경할 수 없음
const int *sub1(void)
{
	// static : 함수의 scope가 끝나도, n이 stack에 있지 않기 때문에, 읽을 수 있음
	static int n = 5;
	cout << n << endl;
	return &n;
}
```

- return 형이 const인 경우, return 값을 변경할 수 없다!



------

### 1.7 함수 중복 정의 (function overloading)

1) 동일한 이름의 함수를 복수 개 정의하는 것을 함수의 중복 정의라 한다.

2) 함수 **파라미터의 자료형이 다르거나 파라미터의 개수가 다르면** 중복정의 할 수 있다.

- return 타입만 다른 경우는 중복 정의되지 않는다. (return 타입은 함수의 정의에 포함되지 않는다.)

  ```c++
  #include <iostream>
  #include <stdlib.h>
  using namespace std;
  
  //void swap(int *a, int *b);
  //void swap(double *d1, double *d2);
  // 정수,실수형일 때는 그냥 인자 2개짜리 함수 만들기 (다른 형이 여러개일 때 쓰자..!)
  void swap(void *a, void *b, size_t size);
  
  void main(void)
  {
  	int n = 5, k = 6;
  	double d1 = 3.14, d2 = 2.54;
  	swap(&n, &k, sizeof(n));
  	swap(&d1, &d2, sizeof(d1));
  	cout << n << ' ' << k << endl;
  }
  
  void Memcpy(void *dst, const void *sou, size_t cnt)
  {
  	char * d = (char *)dst;
  	const char * s = (const char *)sou;
  	for (; cnt > 0; cnt--) *d++ = *s++;
  }
  
  void swap(void *a, void *b, size_t size)
  {
  	void *temp = malloc(size);
  	Memcpy(temp, a, size);
  	Memcpy(a, b, size);
  	Memcpy(b, temp, size);
  	free(temp);
  }
  
  /*
  void swap(int *a, int *b)
  {
  	int temp;
  	temp = *a;
  	*a = *b;
  	*b = temp;
  }
  
  void swap(double *d1, double *d2)
  {
  	double temp;
  	temp = *d1;
  	*d1 = *d2;
  	*d2 = temp;
  }
  */
  ```



- ```c++
  #include <stdio.h>
  
  struct stream{
  	void printf(int);
  	void printf(char);
  	void printf(double);
  	void printf(const char *);
  };
  
  void stream::printf(int n)
  {
  	//printf는 전역함수 --> :: 붙이기
  	::printf("%d", n);
  }
  
  void stream::printf(char c)
  {
  	::printf("%c", c);
  }
  
  void stream::printf(double d)
  {
  	::printf("%lf", d);
  }
  
  void stream::printf(const char * str)
  {
  	::printf("%s", str);
  }
  
  // cout도 중복정의! (알맞은 인풋형을 찾아 함수 호출)
  void main(void)
  {
  	stream c;
  	c.printf(5);
  	c.printf(3.14);
  	c.printf("seoul");
  }
  ```



3) c++에서 함수를 중복 정의할 수 있는 것은 철저한 함수의 원형에서 비롯된다.

- 네임 맹글링(name mangling)

  프로그램에서 사용한 함수나 변수의 이름이 컴파일단계에서 컴파일러의 규칙에 따라 이름을 변형하는 것으로 네임 데코레션(name decoration)이라고도 한다. C++의 함수중복정의(function overloading)로 만들어진 동일한 이름의 함수들을 식별하기 위해 필요한 작업이다,

  하지만 네임 맹글링의 규칙은 C와 C++ 컴파일러가 서로 다를 뿐만 아니라 C++ 컴파일러끼리도 표준화되어 있지 않아 특정 컴파일러에서 만든 라이브러리(library)를 다른 컴파일러에서 사용하려 할 경우 링크오류를 발생시키는 원인이 되기도 한다.

- 호출 규약(call protocol, calling convention)

  함수 호출방식에 대한 약속으로 인수전달, 이름규칙, 스택정리 등에 대해 함수의 호출측(caller)과 함수정의부(callee) 간의 약속입니다.

  호출규약의 종류에는 _cdecl, pascal, __thiscall 등등

- _cdecl 규약

  c언어의 기본 규약이다. name decoration이 "_함수명" 으로 지정되어있기 때문에 함수의 중복 정의가 불가하다! (함수의 인자가 다르더라도 함수명만 같으면 같은 함수로 취급한다.)



4) 다음은 중복정의가 불가능한 경우이다.

- 리턴 타입만 다른 경우 중복정의 불가

  ```c++
  	int sub(void) { … }
  	void sub(void) { … }
  ```

- 포인터 인수 타입과 배열 인수타입의 함수는 중복정의 불가

  ```c++
  	void sub(char * ptr) { … }
  	void sub(char str[]) { … }
  	void sub(const char * ptr) { … } // 중복정의 가능
  ```

- const가 있는 value 인수 타입과 일반 value 인수 타입은 중복정의 불가

  ```c++
  	void sub(const int n) { … }
  	void sub(int n) { … }
  ```

- 레퍼런스 인수 타입과 value인수 타입의 경우 중복 정의는 가능하지만 모호한 호출 오류 발생

  ```c++
  	int sub(int n) { … }
  	int sub(int & rn) { … }
  ```

- 디폴트 파라미터로 중복정의 된 함수와 중복 정의는 가능하지만 모호한 호출 오류 발생

  ```c++
  	void sub(int n = 5) { … }
  	void sub(void) { … }
  ```



------

### 1.8 디폴트 파라미터 (default parameter)

- **함수 선언문에 만들기!! (NOT 함수 정의)**

1) 함수 호출 시 파라미터에 전달될 아규먼트(argument)가 부족할 경우 대신해서 전달되는 값을 디폴트 파라미터라 한다.

2) 대신 전달될 디폴트 파라미터 값은 함수 **선언문**에 미리 정의되어 있어야 한다.

3) 선언문에 정의할 때, **우측 파라미터부터 정의**해야 한다.

- ```c++
  void sub(int a, int b = 10, int c = 20);
  ```

  

4) 함수 호출 시 디폴트 파라미터 값의 사용은 우측부터 사용해야 하며, 중간 또는 좌측 파라미터만 디폴트 파라미터를 사용할 수 없다. 

- ```c++
  	sub( , , 5); // error
  	sub(4,  , 5); // error
  	sub(5); // default parameter 10, 20
  	sub(5, 10); // default parameter 20
  ```

  

5) 따라서 **자주 사용되는 아규먼트 값**의 경우 디폴트 파라미터로 두어 호출의 편의를 제공할 수 있다.

6) 디폴트 파라미터를 부여한 함수를 중복정의 할 경우 모호한 호출을 고려해야 한다!

7) 함수호출을 검사하기 위한 함수선언문을 여러 개 둘 경우, 디폴트 파라미터의 값을 달리 부여할 수 있다.

- ```c++
  	void sub(int n = 10);
  
  	void main(void)
  	{
  		sub();
  	}
  	void func(void)
  	{
  		void sub(int n = 5);
  		sub();
  	}
  	void sub(int n)
  	{
  	}
  ```



```c++
#include <iostream>
#include <time.h>
using namespace std;

// default parameter 지정은 중간에 skip할 수 없음
void DisplayDate(int day, int month = 1, int year = 2019);
void DisplayDate(void); // void DisplayDate(int day = 1, int month = 1, int year = 2019); 과는 중복정의가 불가능함 <-- 함수의 호출부가 같기 때문!!


void main(void)
{
	DisplayDate(20);
	DisplayDate();
}

void DisplayDate(void)
{
	// time_t : typedef long
	time_t lt;
	// tm : struct st
	tm *ct;

	time(&lt);
	ct = localtime(&lt);
	DisplayDate(ct->tm_mday, ct->tm_mon + 1, ct->tm_year + 1900);
}

// 자주 사용하는 변수일수록 오른쪽에 배치
// default parameter는 오른쪽부터 지정 가능
// 부족한 개수만큼 오른쪽에서 default parameter를 읽음
void DisplayDate(int day, int month, int year)
{
	cout << year << "/" << month << "/" << day << endl;
}
```



------

### 1.9 레퍼런스 (reference)

- 참조변수는 **항상 선언과 동시에 초기화**가 이뤄져야 한다!
- 하나의 변수에 여러 참조변수를 생성할 수 있다.

1) 기억공간의 이름(변수명)에 또다른 이름(alias, 참조 변수)을 부여하는 것을 말하며, 하나의 기억공간에 복수 개의 참조 변수명을 부여할 수 있다.

2) 참조 변수는 '&' 을 이용해서 선언한다.

- 형식] 자료형 & 참조변수명 = 기존변수명;
- **또다른 공간의 할당을 받는 것이 아니다!** 기존의 공간과 같은 공간을 공유한다!



3) 주소연산자와 참조연산자의 구별은 좌측에 자료형의 등장 여부로 판단할 수 있다.

- ```c++
  	int n = 5;
  	int & rn = n; // reference
  	int * p = &n; // address
  ```



4) 레퍼런스를 함수의 인수 전달에 적용한 것을 call by reference라 한다.

- 인수 전달 수식 == 선언과 동시에 초기화

  ```c++
  	void subv(int n) // int n = k;		// call by value
  	{ … } 
  	void subp(int * p)  // int * p = &k;	// call by address(pointer)
  	{ … }
  	void subr(int & rn)  // int & rn = k;	// call by reference
  	{ … }
  ```



5) 함수의 리턴값을 레퍼런스로 되돌릴 경우 임시 기억공간을 만들지 않고 **기억공간 자체가 리턴** 된다.



```c++
#include <iostream>
using namespace std;

void subv(int k);
void subp(int * p);
void subr(int & r);
int & rsub2(int & r);
int rsub1(int & r);
int rsub(int & r);
int *psub(int n);
int vsub(int n);

void main(void)
{
	int n = 5;
	int & r = n;	// 참조 , 좌측에 자료형
	cout << r << endl;
	r = 10;
	cout << n << endl;
	cout << &n << " " << &r << endl;

	subv(n);
	cout << n << endl;

	subp(&n);
	cout << n << endl;

	subr(n);
	cout << n << endl;

	vsub(n);	// int imsi = n;
	psub(n);	// int *imsi = &n;
	rsub1(n);	// int imsi = r;
	rsub2(n) = 1000000;	// int & imsi = r;	r = 0;
	cout << r << ' ' << n;
}

int & rsub2(int & r)
{
	return r;
}

int rsub1(int & r)
{
	return r;
}

int rsub(int & r)
{
	return r;
}

int *psub(int n)
{
	return &n;
}

int vsub(int n)
{
	return n;
}

//call by address
void subp(int * p)
{
	*p = 10;
}

//call by value
void subv(int k)	// int k = n;
{
	k = 0;
}

//call by reference
void subr(int & r)	// int &r = n;	선언과 동시에 초기화
{
	r = 200;
}
```



```c++
// 공용체 대신 이렇게 쓸 수 있음
#include <iostream>
using namespace std;

void main(void)
{
	long data = 0x12345678;
	//long &word = data;
	short (& word)[2] = (short (&)[2])data;
	char(&byte)[4] = (char(&)[4])data;
	cout << hex << word[1] << endl;
	cout << hex << (int)byte[1] << endl;
}
```



```c++
	// 포인터 참조
	const char * cstr = "seoul";
	char * & rstr = (char * &)cstr;
	// *rstr = 'A'; // 읽기 전용 메모리에 기록하기 때문에 런타임 오류 발생
	rstr = "korea";
	const char * const & rcstr = cstr; // 다른 주소를 갖지 않기 위한 참조
	// rcstr = "KOREA"; // 변경불가 
```



```c++
	// 배열, 배열포인터, 포인터배열, 더블포인터 참조
	char str[] = "seoul";
	char (& rstr)[6] = str; // 배열참조의 경우 요소 개수를 상수로 명시하고 괄호사용

	char name[][5] = {"kim", "park"}; // 2차원배열
	char (& rname)[2][5] = name; // 모든 차원에 배열의 크기를 상수로 명시
	char (* pname)[5] = name; // 배열포인터
	char (* & rpname)[5] = pname; // 배열포인터의 참조

	const char * cname[] = {"kim", "park"};
	const char * (& rcname)[2] = cname; // 포인터배열의 참조
	const char * * pcname = cname; // 더블포인터
	const char * * & rpcname = pcname; // 더블포인터의 참조
```



------

### 1.10 인라인(inline) 함수

- runtime에 정해지는 동적 바인딩 함수는 inline 될 수 없다! (ex: 함수 포인터, ...)

1) 예약어 'inline' 으로 정의되는 함수를 inline 함수라 한다.

- ```c++
  inline void Add(int a, int b) { … }
  ```



2) 인라인 함수는 함수 정의부가 컴파일 타임에 함수의 호출 위치에 그대로 인라인 확장(inline extension) 된다.

3) 함수 호출과 복귀로 발생하는 비용(prefix, suffix code)을 줄일 수 있으나, 잦은 호출이 있는 경우 프로그램의 부피가 커질 수 있는 단점이 있다.

4) 구조가 간단한 함수를 inline함수로 사용해야 효율성을 높일 수 있으며, 제어문을 많이 포함한 함수는 고려해야 한다.

5) 클래스 또는 구조체 안에 멤버함수 정의부를 두면, 자동 인라인 함수화 된다.

6) 소스코드를 .h 와 .cpp로 분리 작성할 경우, 컴파일 타임에 **인라인함수의 코드가 인라인 확장할 수 있도록 함수 정의부는 헤더파일에 둔다.**

- ```c++
  // A.H ////////////////////////////////
  
  class A{
  	int res;
  public:
  	inline int add(int a, int b);
  	void print(void);
  };
  
  inline int A::add(int a, int b) 
  {
  	res = a + b;
  	return res;
  }
  ```

- ```c++
  // A.CPP /////////////////////////////
  
  #include <iostream>
  using namespace std;
  #include "A.h“
  
  //inline int A::add(int a, int b) 
  //{
  //	res = a + b;
  //	return res;
  //} 
  
  void A::print(void)
  {
  	cout << res << endl;
  }
  ```

- ```c++
  // Main.CPP /////////////////////////
  
  #include "A.h"
  
  void main(void)
  {
         A aa;
         aa.add(5, 10);
         aa.print();
  }
  ```



7) inline 함수화가 불가능한 상황

- 파생클래스에 재정의 된 가상 함수가 동적바인딩(부모 포인터 형식으로 호출) 되는 경우 인라이닝 될 수 없다. (실행시간 함수 바인딩으로 인해) 다만 정적바인딩(파생의 타입으로 호출)의 경우 인라이닝(inlineing) 될 수 있다.
- 재귀 함수는 호출의  depth로 인해 코드가 비대해질 수 있다.
- **가변인수 함수**는 컴파일 타임에 파라미터의 개수를 파악할 수 없어서 인라이닝 될 수 없다.
- **함수 포인터**를 통해 함수를 호출하는 경우



------

### 1.11 입력 오류 처리

```c++
#include <iostream>
using namespace std;

char grade[11] = { 'F', 'F', 'F', 'F', 'F', 'F', 'D', 'C', 'B', 'A', 'A' };

void main(void)
{
	int score;
	do{
		cout << "SCORE : ";
		cin.clear();
		cin.ignore(cin.rdbuf()->in_avail());
		cin >> score;
	} while (cin.fail() || score < 0 || score > 100);

	cout << "GRADE : " << grade[score / 10] << endl;
}
```

- cin.rdbuf() : 입력 버퍼를 담당하는 개체 포인터(streambuf *)를 리턴
- in_avail() : streambuf클래스의 멤버함수로 버퍼에 남아있는 문자 개수를 리턴



------

### 1.12 동적 메모리와 연산자 new, delete

- malloc()은 함수, new 는 연산자
- malloc을 쓸 수 없는 경우가 있다.(클래스의 생성자 함수를 호출하지 못하는 경우) --> new를 써야 함

1) c++에서는 연산자 new, delete를 제공해서 동적 메모리를 확보하고 반환한다.

2) malloc()과 free()와 같은 역할을 한다.

- malloc을 통해 주소를 반환하면, **주소의 -16번지**에는 **반환받은 메모리의 크기**가 저장되어 있다.
- 따라서 반환된 주소를 변경하고 free를 하려하면, 정상적인 메모리의 반환이 일어나지 않는다.
- 따라서 주소를 이동하고 싶을 때는, 포인터의 변경보다는 배열의 접근이 좋다!



3) new는 우측에 자료형이 사용되며, 자료형 크기만큼 메모리를 확보한다.

- 형식] 포인터 변수 = new 자료형;



4) 정상적으로 메모리를 확보했다면 확보된 메모리의 시작주소를 리턴하고 실패했을 때 널포인터(nullptr)를 리턴하거나 또는 예외를 던진다.

5) new로 확보된 메모리를 반환할 때, delete를 사용한다.

- 형식] delete 포인터변수;
- new와 delete의 관계도 malloc과 free의 관계와 같다.



```c++
#include <iostream>
using namespace std;

void main(void)
{
	int *np = new int;
	cout << *(int *)((char *)np - 16) << endl;
	delete np;

	int size;
	cout << "SIZE :";
	cin >> size;

	char *cp = new char[size];	// 오른쪽의 자료형을 가리키는 포인터 형태로 선언
	cout << *(int *)((char *)cp - 16) << endl;
	delete cp;
}
```



6) new[]로 확보한 메모리는  delete []을 사용해서 메모리를 반환해야 한다.

- ```c++
  #include <iostream>
  #include <string.h>
  using namespace std;
  
  void main(void)
  {
  	char temp[100];
  	int len;
  	char *str;
  
  	cout << "STRING : ";
  	cin.getline(temp, 100);
  	len = strlen(temp);
  
  	str = new char[++len];
  	strcpy_s(str, len, temp);
  	cout << str << endl;
  	
  	// 배열을 반환할 때는 '[]'을 쓰는 것을 원칙으로 함!
  	// 여기서는 안 써도 되지만, 꼭! 써야하는 경우가 있음
  	delete[] str;
  }
  ```



- ```c++
  #include <iostream>
  #include <string.h>
  using namespace std;
  
  void main(void)
  {
  	char temp[100];
  	int len;
  	char **str;
  	int i;
  	int size;
  	
  	cout << "SIZE : ";
  	cin >> size;
  	str = new char *[size];
  	
  	for (i = 0; i < size; i++)
  	{
  		cout << "STRING : ";
  		cin.clear();
  		cin.ignore(cin.rdbuf()->in_avail());
  		cin.getline(temp, 100);
  
  		len = strlen(temp);
  		str[i] = new char[++len];
  		strcpy_s(str[i], len, temp);
  	}
  
  	for (i = 0; i < size; i++)
  	{
  		cout << str[i] << endl;
  	}
  
  	for (i = 0; i < size; i++)
  	{
  		delete[] str[i];
  	}
  	delete[] str;
  }
  ```



7) c++ 표준에서 제공되는 연산자 new의 종류는 3가지가 있다.

- 예외를 던지는 new (실패시 bad_alloc 예외를 던짐)
- 예외를 던지지 않는 new (실패시 nullptr 리턴)
- 위치지정(placement) 초기화의 new (메모리 할당 없이 기존하는 공간의 초기화를 위한 기능으로 초기화된 공간의 주소를 리턴)



------

### 1.13 enum(나열, enumeration) 형

- enum을 선언했으면, 정수형이 아닌 **enum형**을 사용해야 한다!

1) 예약어 'enum'은 순차적으로 나열된 정수형 상수를 만들 때 사용한다.

- 형식] enum 나열형이름 {상수1, 상수2, 상수3, ...};
- 예] enum SU {ONE = 1, TWO, THREE, FIVE = 5, SIX};



2) 예약어 ‘enum’을 생략하고 열거형 이름만으로 변수를 선언할 수 있다. (generalization)

- ```c++
  	enum BOOL {FALSE, TRUE} ;
  	BOOL b;
  ```



3) enum형으로 선언된 변수의 크기는 int형의 크기를 따르지만 int형과 분명히 다른 자료형이다.

4) C언어에서는 enum형으로 선언된 변수에 int형의 정수값도 대입 가능했지만 C++에서는 enum형의 상수만 대입 가능하다.

- ```c++
  enum week{SUN, MON, TUE, WED, THU, FRI, SAT};
  week wday;
  // wday = 3; //  error C2440: '=' : 'int'에서 'week'(으)로 변환할 수 없습니다
  wday = MON;
  //int n = SUN; // 에러 없지만 올바르지 않은 초기화  -> wday n = SUN;
  ```



------

### 1.14 이름 없는 공용체

- 변수 선언 없이, 그냥 변수를 사용 가능하게 할 수 있다.

1) 공용체 형틀 정의 시 이름 없는 형태를 취하는 공용체이다.

- ```c++
  	union {
  		long data;
  		short word;
  		char byte;
  	};
  ```



2) 공용체 이름이 없으므로 공용체 변수 선언은 불가하다. 대신 멤버 이름을 바로 사용할 수 있다.

- ```c++
  	data = 0x1234567890;
  	cout  << word << byte; 
  ```



3) 다른 변수 이름들과의 중복문제로 이름 없는 공용체 형틀은 **함수** **내에** **정의**하는 것을 기본으로 하지만 함수 외부에 정의 할 수도 있다. 다만 반드시 static으로 정의해야 한다.

- ```c++
  #include <iostream>
  using namespace std;
  
  // 그럼에도 외부에 정의하고 싶다면, static으로 정의 (외부 파일과의 중복 피함)
  /*
  static union{
  	long data;
  	short word;
  	char byte;
  };
  */
  
  void main(void)
  {
  	// 다른 변수들과의 중복을 피하기 위해, 함수 내부에 정의하는 것이 원칙
  	union{
  		long data;
  		short word;
  		char byte;
  	};
  
  	data = 0x12345678;
  	cout << hex << word << endl;
  }
  ```



4) 구조체도 구조체나 공용체 안에 둘 경우 이름없는 형태를 취할 수 있다.

- 구조체 자체(단독 사용)는 이름없는 구조체를 지원하지 않는다.

- ```c++
  	union KEY{
  		short code;
  		struct{ // anonymous struct 
  			char ascii, scan;
  		};
  	};	
  
  	KEY key;
  	key.code = 0x001B;
  	if(!key.ascii) { … }
  ```



------

### 1.15 공간이름(namespace)과 예약어 using

1) 여러 개의 파일에 존재하는 전역변수와 전역함수의 중복되는 문제를 해결하기 위해 공간이름을 둘 수 있다.

2) 공간이름 내의 변수 또는 함수는 스코프( scope, :: ) 연산자로 구분해서 접근한다.

3) 예약어 using의 사용으로 공간이름을 생략하고 변수나 함수를 접근할 수 있습니다.

```c++
#include <iostream>
// 같은 변수나 함수명이 있더라도, 다른 공간에 있으면 중첩을 피할 수 있음! --> namespace
using namespace std;

// A코드
namespace A{
	int no = 5;
	void sub(void)
	{
		cout << no << endl;
	}
}

// B코드
namespace B{
	int no = 10;
	void sub(void)
	{
		cout << no << endl;
	}
}

// 원래는 cout도 std::cout, std:endl 이었음
void main(void)
{
	A::sub();
	cout << B::no << endl;

	// 이후에는 A라는 공간을 사용하겠다! 
	using namespace	A;
	sub();
	cout << no << endl;

	using namespace B;
	//sub();	//에러 (A와 B둘다 다 열려있음)
	B::sub();
}
```



4) namespace를 통한 전역변수 접근보다는 지역변수가 우선시 된다.

- ```c++
  #include <iostream>
  #include <iomanip>
  using namespace std;
  
  void main(void)
  {
  	int left = 5;
  
  	// 10자리 왼쪽 정렬
  	// but 지역변수가 우선되기 때문에 5가 출력
  	cout << left << setw(10) << "seoul" << 10 << endl;
  	
  	// std::left 해줘야 함
  	cout << std::left << setw(10) << "seoul" << 10 << endl;
  }
  ```



5) 복잡하고 긴 공간이름을 간단히 다른 이름으로도 rename할 수 있다.

- ```c++
  	namespace Box {
  		namespace Fruit {
  			int cnt;
  		};
  	};
  
  	namespace Apple = Box::Fruit;
  	Apple::cnt = 100;
  ```



- 왜 표준에서 제공되는 cin과 cout은 namespace std 안에 선언되어 있을까?

  기존의 cout과 표준의 cout을 모두 사용하기 위해 공간을 분리했다.

  기존의 cout을 버린 현재에도 이전의 코드와의 호환을 위해 남아있는 것이다.



------

### 1.16 c++ 구조체를 이용한 요일 출력

```c++
#include <iostream>
#include <time.h>
using namespace std;

struct Date{
private:
	int year, month, day, week;
	void CalcDate(void); // 요일 계산하는 멤버함수	--> 초기값이 없는데 외부에서 호출되면 안됨
public:
	void InitDate(void); // 년, 월, 일 정보를 시스템에서 읽어오는 멤버함수
	void InitDate(int d, int m, int y = 2019); // 년, 월, 일 정보를 인수로 전달받는 멤버함수
	void DisplayDate(void); // 년, 월, 일, 요일 출력하는 멤버함수
};

void Date::InitDate(void)
{
	time_t lt;
	tm *ct;

	time(&lt); 
	ct = localtime(&lt);
	year = ct->tm_year + 1900;
	month = ct->tm_mon + 1;
	day = ct->tm_mday;
}

void Date::InitDate(int d, int m, int y)
{
	year = y;
	month = m;
	day = d;
}

void Date::CalcDate(void)
{
	time_t lt;
	tm *ct;

	time(&lt);
	ct = localtime(&lt);
	ct->tm_year = year - 1900;
	ct->tm_mon = month - 1;
	ct->tm_mday = day;
	mktime(ct);
	
	week = ct->tm_wday;
}

void Date::DisplayDate(void)
{
	CalcDate();
	cout << year << "/" << month << "/" << day << "/" << week << endl;
}

void  main(void)
{
	Date today;
	today.InitDate();
	today.DisplayDate();

	Date oneday;
	oneday.InitDate(25, 12);
	oneday.DisplayDate();
}
```



------

### 1.17 c++ 구조체를 이용한 성적처리

```c++
#include <iostream>
using namespace std;

//const char *grade = "FFFFFFDCBAA";
struct Score{
private:
	char * name; // 동적 할당
	int  kor, eng, mat;
	int tot;
	double ave;
public:
	void InitScore(void);
	void CalcScore(void);
	void DisplayScore(void);
	void DeleteMemory(void);
};

void Score::InitScore(void)
{
	char temp[50];
	int len;

	cout << "Name : ";
	cin.clear();
	cin.ignore(cin.rdbuf()->in_avail());
	cin >> temp;

	len = strlen(temp);
	name = new char[++len];
	strcpy_s(name, len, temp);

	cout << "Score : ";
	cin >> kor >> eng >> mat;
}

void Score::CalcScore(void)
{
	tot = kor + eng + mat;
	ave = tot / 3.0;
}

void Score::DisplayScore(void)
{
	// 함수 내부에서 자주 쓰는 변수는 static으로 선언
	// 매번 초기화되는 것을 방지
	static char *grade = "FFFFFFDCBAA";
	cout << name << '\t' << grade[kor / 10] << '\t' << grade[eng / 10] << '\t' << grade[mat / 10] \
		<< '\t' << tot << '\t' << ave << endl;
}

void Score::DeleteMemory(void)
{
	delete[] name;
}

void main(void)
{
	int cnt;
	int i;

	cout << "Count : ";
	cin >> cnt;

	Score *stu = new Score[cnt];
	for (i = 0; i < cnt; i++)
	{
		stu[i].InitScore();
		stu[i].CalcScore();
	}

	for (i = 0; i < cnt; i++)
	{
		stu[i].DisplayScore();
		stu[i].DeleteMemory();
	}
	delete[] stu;
}
```

