class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int rev=0;
        if(x<0){
            return false;
        }
        while(temp!=0){
            temp=temp%10;
            rev=rev*10+temp;
            temp=temp/10;
        }
            
        if(x==rev){
            return true;
        }else{
            return false;
        }
    }
}

