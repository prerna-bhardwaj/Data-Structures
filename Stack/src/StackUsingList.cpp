#include<iostream>
using namespace std;

class Node {
    public:
        int val;
        Node* next;

        Node() {}
        Node(int val) {
            this->val = val;
            next = NULL;
        }
};

class StackUsingList {
    Node *head;
    public: 
        void push(int val) {
            if(head == NULL)
                head = new Node(val);
            else {
                Node *temp = new Node(val);
                temp->next = head;
                head = temp;
            }
        }

        int pop() {
            if(head == NULL)
                return -1; 
            int val = head->val;
            head = head->next;
            return val;
        } 

        int top() {
            return (head == NULL) ? -1 : head->val;
        }

        bool isEmpty() {
            return (head == NULL);
        }
};

int main() {
    StackUsingList obj;

    obj.push(10);
    obj.push(20);
    obj.push(30);
    obj.push(40);

    cout << "Top : " << obj.top()<<endl;
    cout << "Element popped : " << obj.pop()<<endl;
    cout << "Top : " << obj.top()<<endl;

    cout<< "Is Empty : "<< obj.isEmpty() << endl;
}