#include<stdio.h>

void swap(int *a, int *b) {
    if((*a) > (*b)) {
        int temp = (*a);
        (*a) = (*b);
        (*b) = temp;
    }
}

     int q = 10;
void func() {
}

int main() {
    int a = 5, b = 2;
    printf("%d\n", q);
    q = 20;
    printf("%d\n", q);
    printf("Before : %d %d\n", a, b);
    // pass by reference for a
    // pass by value for ptr->a
    swap(&a, &b);
    printf("After : %d %d\n", a, b);
    func();
    func(10, 20, "anc");
    return 0;
}