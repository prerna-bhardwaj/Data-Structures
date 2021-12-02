#include<iostream>
using namespace std;

int findSum(int arr[], int n) {
    cout<<n<<endl;
    int maxValue = 0;
    int currMax = 0;
    for(int i = 0; i < n; i++) {
        currMax += arr[i];
        maxValue = max(maxValue, currMax);
        if(currMax < 0)
            currMax = 0;
    }
    return maxValue;
}

int main() {
    int arr[] = {-2, -3, 1, 4, -1 ,0, -5, -8, 19, -2, 3};
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("Max Subarray Sum : %d", findSum(arr, n));
    return 0;
}