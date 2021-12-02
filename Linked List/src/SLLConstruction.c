#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct Node {
    int val;
    struct Node *next;
};

void printList(struct Node *head) {
    struct Node *curr = head;
    while(curr != NULL) {
        printf("%d ", curr->val);
        curr = curr->next;
    }
    printf("\n");
}

void insert(struct Node** head, int value, int *length) {
    (*length)++;
    struct Node *curr = (struct Node*)malloc(sizeof(struct Node*));
    curr->val = value;
    curr->next = (*head);
    (*head) = curr;
}

bool isEmpty(struct Node *head) {
    return (head == NULL);
}

int main() {
    struct Node *head = NULL;
    head = (struct Node*) malloc(sizeof(struct Node));

    int length = 0;
    insert(&head, 40, &length);
    insert(&head, 30, &length);
    insert(&head, 20, &length);
    insert(&head, 10, &length);
    printList(head);
    printf("\n%d\n", length);
    printf("%d", isEmpty(head));
    return 0;
}