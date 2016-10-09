//You have an array of bytes which contains encoded integers. Each integer consists of either 1 or 2 bytes. If the first bit (left-most bit) of the first byte is 0, then it’s a 1 byte integer. If the first bit (left-most bit) of the first byte is a 1, then it’s a 2 byte integer. Given an index “k” which is the starting byte of one of the integers in the array, find the next integer.



//if k == 0, k+2

b = [ 1xxxxxxx 0xxxxxxx 1xxxxxxx 1xxxxxxx ]
b.length = 4
1st integer = indexes 0+1
2nd integer = index 2+3
k=0
return b[2+3]

int getNextInteger(byte[] b, int k) {
    if (b[k] & 0x10000000 == 0x10000000){// && k < b.length - 1
        return b[k+2] & 0x10000000 == 0 ? b[k+2] : (b[k+2] << 8 + b[k+3]);
    }
    else
       return b[k+1] & 0x10000000 == 0 ? b[k+1] : (b[k+1] << 8 + b[k+2]);

}


// b = 0 1 1 1 0 k , k=5 , break=0, k-i=5
// b = 0 1 1 0 k break at k-4
// b = 1 1 1 1 1 0 k, k=6, i=-1, k-1=7
// b = 0 0 0 k, k=3, i=1, k-i=2
// b = 1 1 k

int getPrevInteger(byte[] b, int k) {
    if ( b[k-1] & 0x10000000 == 0x10000000)
        return b[k-2] << 8 + b[k-1];
    int i = k-2;
    for(; i >=0 ; i--){
      if(b[i] & 0x10000000 == 0x00000000)
          break;
    }
     if(k - i % 2!=0)
         return b[k-2]<< 8+ b[k-1];
     else
         return b[k-1];

}
