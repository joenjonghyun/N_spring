package kr.co.patternbot.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component @Data @Lazy //레이지(게으른) 로딩 이라고 함 Lazy Loading 디비가 필요없다는 뜻 내가 호출 할 때 인스턴스를 생성한다는 것.
//컴포넌트를 사용하는 것은 순수자바를 쓰겠다는 의미, 라우터도 미들웨어도 안 쓴다는 의미? 레파지토리는 당연하고.
//제네릭은 하나만 만들어서 넣으면 됨 안에있는 내용물만 생각하다는 거 같음. 사용 이유는 메모리를 극한으로 아끼자는 의미. 재활용성이 좋음
public class Box<T> {
    private ArrayList<T> list;
    public Box(){this.list = new ArrayList<>();}
    //save, update, delete, findAll, findByName, findById, count, existById, clear
    //add, set, remove, get(), X, get(i), size, X, clear

    public void add(T t){ list.add(t);}
    public void set(int i, T t){list.set(i,t);}
    public void remove(T t){list.remove(t);}
    public List<T> get(){return list;}
    public T get(int i){return list.get(i);}
    public int size(){return list.size();}
    public void clear(){list.clear();}






}
