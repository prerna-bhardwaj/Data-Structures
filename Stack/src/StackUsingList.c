#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct Node {
    int val;
    struct Node* next;
};

// insert at head of linked list
void push(struct Node** head_ref, int value, int *length) {
    struct Node *curr = (struct Node*) malloc(sizeof(struct Node*));
    curr->val = value;
    curr->next = (*head_ref);
    (*head_ref) = curr;
    (*length)++;
}

int top(struct Node* head) {
    // if(head == NULL)
    //     return -1;
    // return head->val;
    return (head == NULL) ? -1 : head->val;
}

// remove the first node from linked list
int pop(struct Node** head_ref, int *length) {
    if((*head_ref) == NULL)
        return -1;
    struct Node *head = (*head_ref);
    int value = head->val;
    (*head_ref) = head->next;
    (*length)--;
    return value;
}

bool isEmpty(struct Node* head) {
    return (head == NULL);
}

// Size = o(n) time | O(1) space   -> O(1) time,space

int main() {
    int length = 0;
    struct Node* head = NULL;
    
    printf("Is Empty : %d\n", isEmpty(head));
    printf("Topmost element : %d\n", top(head));
    printf("Length : %d\n", length);

    head = (struct Node*) malloc(sizeof(struct Node*));

    // 40 30 20 10
    push(&head, 40, &length);
    push(&head, 30, &length);
    push(&head, 20, &length);
    push(&head, 10, &length);
    
    printf("Is Empty : %d\n", isEmpty(head));
    printf("Topmost element : %d\n", top(head));
    printf("Length : %d\n", length);

    pop(&head, &length);

    printf("Is Empty : %d\n", isEmpty(head));
    printf("Topmost element : %d\n", top(head));
    printf("Length : %d\n", length);

    return 0;
}