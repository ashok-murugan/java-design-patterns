# Prototype Pattern (Real-World Example - Document Management System)

## Scenario:
In a Document Management System, documents can have multiple variants (e.g., different types of reports, invoices, letters) that share many properties. Rather than manually creating each document from scratch, we can use the Prototype Pattern to clone an existing document template and then customize the content where needed.

## Code Implementation:

### Step 1: Define the Prototype Interface
We’ll define a `Document` interface, which includes a method for cloning documents.

```java
interface Document extends Cloneable {
    Document clone();
    void displayDocument();
}
```

## Step 2: Implement Concrete Prototypes
Here we have three types of documents: Report, Invoice, and Letter.

```java
// Concrete Prototype 1: Report
class Report implements Document {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public Document clone() {
        try {
            return (Document) super.clone(); // Shallow cloning
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public void displayDocument() {
        System.out.println("Report [Title: " + title + ", Content: " + content + "]");
    }
}

// Concrete Prototype 2: Invoice
class Invoice implements Document {
    private String invoiceNumber;
    private String recipient;
    private double amount;

    public Invoice(String invoiceNumber, String recipient, double amount) {
        this.invoiceNumber = invoiceNumber;
        this.recipient = recipient;
        this.amount = amount;
    }

    @Override
    public Document clone() {
        try {
            return (Document) super.clone(); // Shallow cloning
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public void displayDocument() {
        System.out.println("Invoice [Invoice #: " + invoiceNumber + ", Recipient: " + recipient + ", Amount: $" + amount + "]");
    }
}

// Concrete Prototype 3: Letter
class Letter implements Document {
    private String recipient;
    private String body;

    public Letter(String recipient, String body) {
        this.recipient = recipient;
        this.body = body;
    }

    @Override
    public Document clone() {
        try {
            return (Document) super.clone(); // Shallow cloning
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public void displayDocument() {
        System.out.println("Letter [Recipient: " + recipient + ", Body: " + body + "]");
    }
}
```
Step 3: Prototype Manager
Now, we’ll create a Prototype Manager to manage and retrieve cloned document prototypes.

```java

import java.util.HashMap;
import java.util.Map;

class DocumentPrototypeManager {
    private Map<String, Document> prototypeMap = new HashMap<>();

    // Register document prototypes
    public void addPrototype(String key, Document prototype) {
        prototypeMap.put(key, prototype);
    }

    // Clone a document prototype
    public Document getPrototype(String key) {
        Document prototype = prototypeMap.get(key);
        return prototype != null ? prototype.clone() : null;
    }
}
```
## Step 4: Usage Example
Now let’s simulate the process of cloning different document types (e.g., Reports, Invoices, and Letters) from prototypes.

```java
public class Main {
    public static void main(String[] args) {
        // Create document prototypes
        Document reportPrototype = new Report("Monthly Sales Report", "Content of the sales report");
        Document invoicePrototype = new Invoice("INV-1234", "John Doe", 2500.75);
        Document letterPrototype = new Letter("Jane Smith", "Dear Jane, your order is confirmed.");

        // Create prototype manager and register prototypes
        DocumentPrototypeManager prototypeManager = new DocumentPrototypeManager();
        prototypeManager.addPrototype("report", reportPrototype);
        prototypeManager.addPrototype("invoice", invoicePrototype);
        prototypeManager.addPrototype("letter", letterPrototype);

        // Clone documents from prototypes
        Document clonedReport = prototypeManager.getPrototype("report");
        Document clonedInvoice = prototypeManager.getPrototype("invoice");
        Document clonedLetter = prototypeManager.getPrototype("letter");

        // Show cloned document details
        clonedReport.displayDocument();
        clonedInvoice.displayDocument();
        clonedLetter.displayDocument();
    }
}
```
## Output:
```yaml
Copy code
Report [Title: Monthly Sales Report, Content: Content of the sales report]
Invoice [Invoice #: INV-1234, Recipient: John Doe, Amount: $2500.75]
Letter [Recipient: Jane Smith, Body: Dear Jane, your order is confirmed.]
```

## Benefits of Using the Prototype Pattern in Document Management:

- **Efficiency in Object Creation**: By cloning documents, we avoid repetitive creation of new documents from scratch. Instead, we can reuse the structure and only modify specific content where needed (e.g., changing the invoice number, recipient, or report content).
- **Consistency**: All documents of a particular type (e.g., invoices or reports) will have a consistent structure and layout, reducing errors.
- **Flexibility**: New document variants can easily be created by cloning an existing template and adjusting the required fields, making the system highly flexible.

## Pitfalls of the Prototype Pattern:

- **Shallow Copying**: If your documents have nested objects or complex structures, shallow cloning might not be sufficient. In such cases, you may need to implement deep cloning to ensure that all nested objects are correctly copied.
- **Complex Cloning Logic**: If a document contains fields or objects that cannot be cloned directly, you might need to implement custom logic for cloning, which can complicate the system.
