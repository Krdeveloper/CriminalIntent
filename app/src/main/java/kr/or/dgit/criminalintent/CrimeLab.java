package kr.or.dgit.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by HKM on 2017-06-13.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context){//singleton pattern
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
        for(int i=0; i<100; i++){ //테스트로 100개 생성
            Crime crime = new Crime();
            crime.setTitle("범죄 #" +i);
            crime.setSolved(i%2==0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime crime : mCrimes){
            if(crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
