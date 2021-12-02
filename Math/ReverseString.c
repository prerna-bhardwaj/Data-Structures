#include<stdio.h>
#include<string.h>

void reverse(char *str1){
    int len = strlen(str1); // use strlen() to get the length of str string  
      
    int left = 0, right = len-1;
    while(left < right) {
        char temp = str1[left];
        str1[left] = str1[right];
        str1[right] = temp;
        left++;
        right--;
    }
}

void fun(int *q) {
    *q = 30;
}

int main() {
    char a[10] = "nvidia";
    printf("%s %d", a, (int)strlen(a));
    reverse(a);
    printf("%s", a);
    int q = 10;
    fun(&q);
    printf("%d", q);
    return 0;
}