// Step 1: Create a map to store the mapped values of each number
Map<Integer, Integer> mappedValues = new HashMap<>();
        
// Step 2: Calculate the mapped value for each number and store it in the map
for (int num : nums) {
    mappedValues.put(num, getMappedValue(num, mapping));
}

// Step 3: Sort the array based on the mapped values using the map
return Arrays.stream(nums)
             .boxed()
             .sorted((a, b) -> {
                 int mappedA = mappedValues.get(a);
                 int mappedB = mappedValues.get(b);
                 if (mappedA != mappedB) {
                     return Integer.compare(mappedA, mappedB);
                 }
                 return 0; // If mapped values are equal, maintain original order
             })
             .mapToInt(Integer::intValue)
             .toArray();
}

private int getMappedValue(int num, int[] mapping) {
StringBuilder mappedValue = new StringBuilder();
String numStr = String.valueOf(num);
for (char ch : numStr.toCharArray()) {
    mappedValue.append(mapping[ch - '0']);
}
return Integer.parseInt(mappedValue.toString());