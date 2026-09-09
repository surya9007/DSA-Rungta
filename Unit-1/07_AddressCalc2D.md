# 2D Array – Row Major & Column Major Order

## 1. 2D Array Representation

A 2D array is represented as:

```text
A[lb1 ... ub1][lb2 ... ub2]
```

Where:

- `lb1` = Lower bound of rows
- `ub1` = Upper bound of rows
- `lb2` = Lower bound of columns
- `ub2` = Upper bound of columns
- `BA` = Base Address
- `C` = Size of each element in bytes

### Number of Rows

```text
nr = ub1 - lb1 + 1
```

### Number of Columns

```text
nc = ub2 - lb2 + 1
```

### Total Number of Elements

```text
n = nr × nc
```

---

# 2. Row Major Order

In **Row Major Order**, elements are stored **row by row**.

For example:

```text
A[0][0]  A[0][1]  A[0][2]
A[1][0]  A[1][1]  A[1][2]
A[2][0]  A[2][1]  A[2][2]
```

Memory order:

```text
A[0][0] → A[0][1] → A[0][2]
        → A[1][0] → A[1][1] → A[1][2]
        → A[2][0] → A[2][1] → A[2][2]
```

## Row Major Address Formula

```text
LOC(A[i][j]) = BA + ((i - lb1) × nc + (j - lb2)) × C
```

### Meaning of Terms

```text
BA          = Base Address
(i - lb1)   = Number of rows before i
nc          = Number of columns in one row
(j - lb2)   = Number of columns before j
C           = Size of each element
```

### Shortcut

```text
LOC(A[i][j])
= BA + [ (i - lb1) × nc + (j - lb2) ] × C
```

---

# 3. Column Major Order

In **Column Major Order**, elements are stored **column by column**.

For example:

```text
A[0][0]  A[0][1]  A[0][2]
A[1][0]  A[1][1]  A[1][2]
A[2][0]  A[2][1]  A[2][2]
```

Memory order:

```text
A[0][0] → A[1][0] → A[2][0]
        → A[0][1] → A[1][1] → A[2][1]
        → A[0][2] → A[1][2] → A[2][2]
```

## Column Major Address Formula

```text
LOC(A[i][j]) = BA + ((j - lb2) × nr + (i - lb1)) × C
```

### Meaning of Terms

```text
BA          = Base Address
(j - lb2)   = Number of columns before j
nr          = Number of rows in one column
(i - lb1)   = Number of rows before i
C           = Size of each element
```

### Shortcut

```text
LOC(A[i][j])
= BA + [ (j - lb2) × nr + (i - lb1) ] × C
```

---

# 4. Row Major vs Column Major

| Feature | Row Major | Column Major |
|---|---|---|
| Storage | Row by Row | Column by Column |
| First changing index | Column `j` | Row `i` |
| Multiplier | `nc` | `nr` |
| Formula | `BA + ((i-lb1)×nc + (j-lb2))×C` | `BA + ((j-lb2)×nr + (i-lb1))×C` |
| Used commonly in | C, C++, Java | Fortran, MATLAB |

---

# 5. Example

Consider:

```text
A[1...3][1...4]
```

Given:

```text
BA = 1000
C  = 4 bytes
i  = 2
j  = 3
```

First calculate:

```text
nr = ub1 - lb1 + 1
   = 3 - 1 + 1
   = 3

nc = ub2 - lb2 + 1
   = 4 - 1 + 1
   = 4
```

## Row Major

Formula:

```text
LOC(A[i][j])
= BA + ((i-lb1) × nc + (j-lb2)) × C
```

Substitute:

```text
= 1000 + ((2-1) × 4 + (3-1)) × 4
= 1000 + (4 + 2) × 4
= 1000 + 24
= 1024
```

### Answer

```text
LOC(A[2][3]) = 1024
```

---

## Column Major

Formula:

```text
LOC(A[i][j])
= BA + ((j-lb2) × nr + (i-lb1)) × C
```

Substitute:

```text
= 1000 + ((3-1) × 3 + (2-1)) × 4
= 1000 + (6 + 1) × 4
= 1000 + 28
= 1028
```

### Answer

```text
LOC(A[2][3]) = 1028
```

---

# 6. Important Formulas for Quick Revision

## Row Major Order

```text
┌─────────────────────────────────────────────────────┐
│ LOC(A[i][j]) = BA + ((i-lb1) × nc + (j-lb2)) × C   │
└─────────────────────────────────────────────────────┘
```

Remember:

```text
ROW → nc
```

---

## Column Major Order

```text
┌─────────────────────────────────────────────────────┐
│ LOC(A[i][j]) = BA + ((j-lb2) × nr + (i-lb1)) × C   │
└─────────────────────────────────────────────────────┘
```

Remember:

```text
COLUMN → nr
```

---

# 7. Easy Trick to Remember

### Row Major

```text
(i - lb1) × nc
```

Because after moving to the next row, we skip **all columns**.

```text
ROW → Number of Columns (nc)
```

### Column Major

```text
(j - lb2) × nr
```

Because after moving to the next column, we skip **all rows**.

```text
COLUMN → Number of Rows (nr)
```

---

# 8. Final 

```text
Rows    = ub1 - lb1 + 1
Columns = ub2 - lb2 + 1

--------------------------------------------

ROW MAJOR:

LOC(A[i][j])
= BA + ((i-lb1) × nc + (j-lb2)) × C

--------------------------------------------

COLUMN MAJOR:

LOC(A[i][j])
= BA + ((j-lb2) × nr + (i-lb1)) × C

--------------------------------------------

ROW MAJOR  → multiply row offset by nc
COLUMN MAJOR → multiply column offset by nr
```

**copyright Surya Mani**
