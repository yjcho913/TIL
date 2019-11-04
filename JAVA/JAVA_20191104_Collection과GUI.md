# [JAVA]

- 학습 일시 : 2019-11-04
- 개요
  - \<Collection> 프레임워크
  - GUI

---

<br>

### 1) \<Collection> 프레임워크

- 자료구조를 추상화하여 만든 정형화된 틀
- 다양한 자료구조를 위한 인터페이스들과 인터페이스를 구현한 클래스들의 묶음
- 구조
  - `<interface> Collection`
    - `<interface> Set` : 순서가 없으며 중복을 허용하지 않음
      - `HashSet`
        - `TreeSet`
    - `<interface> List` : 순서가 있으며 중복을 허용
      - `ArrayList` : `Vector`보다 더 빠름
      - `Vector` : 동기화 시에 사용
        - `Stack`
      - `LinkedList` : `List`와 `Queue`를 상속
    - `<interface> Queue` : FIFO 데이터 구조 
      - ​	`LinkedList` : `List`와 `Queue`를 상속
  - `<interface> Map` : key와 value를 쌍으로 관리
    - `HashMap` : `Hashtable`보다 더 빠름
    - `Hashtable` : 동기화 시에 사용
      - `Properties`

- `java.util.Collection`

  - 데이터의 효율적 관리를 위해 반드시 구현해야 하는 규약 메소드(저장, 검색, 수정, 삭제 등 : CRUD) 를 추상 메소드로 선언한 최상위 인터페이스
  - 선언된 메소드
    - `int size()`
    - `boolean isEmpty()`
    - `boolean add(Object element)`
    - `boolean remove(Objet obj)`
    - `boolean removeAll(Collection other)`
    - `boolean contains(Object obj)`
    - `Iterator iterator()`
    - `Object[] toArray()`

- `java.util.Set extends Collection`

  - 데이터의 중복 저장 x
  - 입력된 순서와 관련 x
  - `HashSet`, `TreeSet`

  ```java
  HashSet set = new HashSet();
  set.add("apple");
  set.add("banana");
  set.add("orange");
  set.add("apple");
  // set = ["apple", "orange", "banana"]
  ```

- `java.util.List extends Collection`

  - 입력된 순서를 통해 데이터의 순차적 관리
  - 중복 허용
  - `ArrayList`, `Vector`, `LinkedList`

  ```java
  List list = new ArrayList();
  list.add("apple");
  list.add("banana");
  list.add("orange");
  list.add("apple");
  // list = ["apple", "banana", "orange", "apple"]
  
  String item = list.get(2);
  // item = "orange"
  
  list.add(2, "kiwi");
  // list = ["apple", "banana", "kiwi", orange", "apple"]
  list.set(4, "grape");
  // list = ["apple", "banana", "kiwi", orange", "grape"]
  list.remove(1);
  // list = ["apple", "kiwi", orange", "grape"]
  ```

- `java.util.Iterator`

  - `Collection`에 의해 관리되는 데이터를 반복 검색하기 위한 인터페이스

  ```java
  Iterator elements = collection.iterator();
  while(elements.hasNext()){
     System.out.println(elements.next());
  }
  ```

- `java.util.Enumeration`

  - 동기화 처리된 `Collection`에 의해 관리되는 데이터를 반복 검색하기 위한 인터페이스

  ```java
  Enumeration elements = vector.elements();
  while(elements.hasMoreElements()){
     System.out.println(elements.nextElement());
  }
  ```

- `java.util.Stack extends Vector`

  - LIFO(Last-In First-Out) 구조
  - 주요 메소드
    - `pop()` : 스택의 맨 위에서 객체를 제거하고 그 객체 반환
    - `push(E item)` : 스택의 맨 위에 객체 추가
    - `peek()` : 스택의 맨 위에 있는 객체 반환. 제거x
    - `Boolean empty()` : 현재 스택이 비어있는지 확인

- `java.util.LinkedList implements List, Queue` 
  - FIFO(First-In First-Out) 구조
  - 주요 메소드
    - `boolean offer(E o)` : 큐에 객체 삽입
    - `E poll()` : 큐에서 데이터 꺼내옴. 만일 큐가 비어있다면 null 반환
    - `E peek()` : 맨 위에 있는 객체 반환. 제거 x. 만일 큐가 비어있다면 null 반환

<br>

### GUI

- TUI (Text User Interface)
  - 프로그램 실행을 Text에 의존해서 실행
  - 예시) 메뉴에서 1을 누르면 추가, 2를 누르면 검색, 3을 누르면 종료.
- AWT (Abstract Window Toolkit)
  - GUI(Graphic User Interface)환경을 구축하기위한 class들의 묶음
  - `java.awt.*`
  - `Object`
    - `Component`
      - `Container`
        - `Panel` - display(x). 한 영역에 두개 이상의 컴포넌트를 붙일때 사용. 컴포넌트 속성을 지정하기위해 사용. 작은 도화지
          - `Applet` : 보안상의 이유로 현재는 쓰이지 않음
          - default : FlowLayout
        - `Window`
          - `Frame` -  display(o). 큰 도화지
          - default : BorderLayout
  - Event 처리 : `compenent`에 기능을 실제로 부여하는 것
- `container` 배치 방법(`LayoutManager`)
  - 컴포넌트를 컨테이너에 어떻게 위치시킬지를 정의
  - FlowLayout(가운데 정렬)
    - 가운데를 기준으로 해서 Component들이 배치
    -  Frame크기에 따라 배치가 변경
    - 글자수에 따라 component의 크기 결정
  - BorderLayout(방위정렬)
    - 방위에 따라 사용자가 임의 배치 가능 (동,서,남,북, 중앙)
    - 상대적으로 큰 영역을 강조할 component를 배치
  - GridLayout(같은 크기 정렬, 행열표현 정렬)
    - Container의 크기를 같은 크기로 나누어 Component를 배치
  - CardLayout(같은 위치 정렬)
    - 같은 위치에 여러개의 Component를 배치할 때 사용

<br>

### Event 처리

- Event : 사건
  - Button을 눌렀을 때
  - Scrollbar 조절바를 움직였을 때
  - TextField에 글자를 썼을 때
  - Frame 우측상단의 x 버튼을 눌렀을 때
- 

<br>

### ) Problems

