public class Triangle {
  private int mSide1;
  private int mSide2;
  private int mSide3;

  public Triangle(int side1, int side2, int side3){
    mSide1 = side1;
    mSide2 = side2;
    mSide3 = side3;
  }

public int checkTriangle(){
  int returnValue = 0;
  if(mSide1+mSide2>mSide3 && mSide1+mSide3>mSide2 && mSide2+mSide3>mSide1){
    if(mSide1 == mSide2 && mSide2 == mSide3){
      returnValue = 1;
    }
    if((mSide1 == mSide2 && mSide2 != mSide3) || (mSide1 == mSide3 && mSide1 != mSide2) || (mSide2 == mSide3 && mSide1 != mSide3)){
      returnValue = 2;
    }
    if(mSide1 != mSide2 && mSide1 != mSide3 && mSide2 != mSide3){
      returnValue = 3;
    }
  }else{
    returnValue = 4;
  }

  return returnValue;

}
}
