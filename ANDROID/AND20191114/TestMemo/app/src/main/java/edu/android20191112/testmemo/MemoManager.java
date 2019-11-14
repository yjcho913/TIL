package edu.android20191112.testmemo;

import java.util.ArrayList;

public class MemoManager {

    private static MemoManager instance;
    private ArrayList<Memo> memoList;

    private MemoManager(){
        memoList = new ArrayList<>();
    }

    public static MemoManager getInstance(){
        if(instance == null){
            instance = new MemoManager();
        }
        return instance;
    }

    void addMemo(Memo memo){
        if(getMemo(memo.getTitle()) == null) memoList.add(memo);
    }

    ArrayList<Memo> getAllMemo(){
        return memoList;
    }


    void updateMemo(String title, Memo m) {
        Memo targetMemo = getMemo(title);
        if(targetMemo != null){
        targetMemo.setContent(m.getContent());
        targetMemo.setDate(m.getDate());
    }
}

    void deleteMemo(String title){
        Memo targetMemo = getMemo(title);
        if(targetMemo != null) memoList.remove(targetMemo);
    }

    Memo getMemo(String title){
        for(int i=0; i<memoList.size(); i++){
            if(memoList.get(i).getTitle().equals(title)) return memoList.get(i);
        }
        return null;
    }

}