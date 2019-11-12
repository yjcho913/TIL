package edu.android20191112.testmemo;

import java.util.ArrayList;

public class MemoManager {

    private static MemoManager instance;
    private ArrayList<Memo> memolist;

    public MemoManager(){
        memolist = new ArrayList<>();
    }

    public static MemoManager getInstance(){
        if(instance == null){
            instance = new MemoManager();
        }
        return instance;
    }

    void addMemo(Memo memo){
        memolist.add(memo);
    }

    ArrayList<Memo> getAllMemo(){
        return memolist;
    }
}