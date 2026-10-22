void main() {

    Base64Convertor base64Convertor = new Base64Convertor();

    Scanner scanner = new Scanner(System.in);

    System.out.println("Encode or Decode? ");
    String operationType = scanner.nextLine();

    if (Objects.equals(operationType, "Encode") || Objects.equals(operationType, "encode")) {
        System.out.println("Give me your text: ");
        String input = scanner.nextLine();
        System.out.println("Base64 is Encoded: " +  base64Convertor.encode(input));
    } else if (Objects.equals(operationType, "Decode") || Objects.equals(operationType, "decode")) {
        System.out.println("Give me base64 encoded value: ");
        String encodedValue = scanner.nextLine();
        System.out.println("Decode is: " + base64Convertor.decode(encodedValue));
    }
}
