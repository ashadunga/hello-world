Candle heights problem
======================
max=a[0];
count=1;
if(a[i]>max){
count=0;
max=a[i];
count=1;
}
else if(a[i]==max){
count+=1;}


static int birthdayCakeCandles(int[] ar) {
int count=1;
        int max=ar[0];
        for(int i=1;i<ar.length;i++){
            if(ar[i]>max){
                count=0;
                max=ar[i];
                count=1;
                
            }else if(ar[i]==max){
                count+=1;
            }
        }
        return count;

    }

