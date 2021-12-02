#include<bits/stdc++.h>
using namespace std;

class Node {
    public :
        int val;
        Node *next;
        Node() {}
        Node(int val) {
            this->val = val;
            this->next = NULL;
        }
};

class LinkedList {
    int length;
    Node *head;

    public :
        LinkedList() {
            head = NULL;
            length = 0;
        }

        void insert(int val) {
            Node *temp = new Node(val);
            temp->next = head;
            head = temp;
            length++;
        }

        void insertTail(int val) {
            if(head == NULL) {
                insert(val);
                return;
            }
            Node *curr = head;
            while(curr != NULL && curr->next != NULL) {
                curr = curr->next;
            }
            Node *temp = new Node(val);
            curr->next = temp;
            length += 1;
        }

        bool remove(int value) {
            if(head == NULL)
                return false;
            Node *prev = NULL, *curr = head;
            while(curr != NULL && curr->val != value) {
                prev = curr;
                curr = curr->next;
            }
            if(curr) {
                prev->next = curr->next;
                delete(curr);
                length -= 1;
                return true;
            }
            return false;
        }

        bool isEmpty() {
            return head == NULL;
        }

        int size() {
            return length;
        }

        void printList() {
            Node *temp = head;
            while(temp) {
                cout << temp->val << " " ;
                temp = temp->next;
            }
            cout<<endl;
        }

        bool isCircular() {
            if(head == NULL)
                return true;
            Node *temp = head->next;
            while(temp && temp != head) {
                temp = temp->next;
            }
            return (temp == head);
        }

        bool hasCycle() {
            if(head == NULL)
                return false;
            Node *slow = head, *fast = head.next;
            while(fast && fast.next) {
                if(fast == slow)
                    return true;
                slow = slow->next;
                fast = fast->next->next;
            }
            return false;
        }

        // thread safe linked list search
        long listSearch(listNodePtr listPtr, long key) {
            listNodePtr    currPtr;
            long        result;

            currPtr=listPtr;
            while (currPtr!=NULL) {
                pthread_mutex_lock(&currPtr->lock);    
                if (currPtr->key==key) {           // As you convert this code for threads,
                    result=currPtr->data;    // think about why I didn't just code
                    return(result);        // 'return(curr->data)' in this if statement.
                } else {
                    currPtr=currPtr->next;
                }
                pthread_mutex_unlock(&currPtr->lock);
            }
            return (-1);     // indicates "not found"
        } // end listSearch
};

int main() {
    LinkedList obj;
    obj.insert(15);
    obj.insert(10);
    obj.insertTail(20);
    cout << "Is Empty : " << obj.isEmpty() << endl;
    cout << " Size : " << obj.size() << endl;
    obj.printList(); 

    obj.remove(30);
    obj.printList(); 

    obj.remove(15);
    obj.printList(); 
}