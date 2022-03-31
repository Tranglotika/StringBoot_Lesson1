// Danh sách các sản phẩm có trong giỏ hàng
let products = [
    {
      name: "Iphone 13 Pro Max", // Tên sản phẩm
      price: 30000000, // Giá mỗi sản phẩm
      brand: "Apple", // Thương hiệu
      count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
      name: "Samsung Galaxy Z Fold3",
      price: 41000000,
      brand: "Samsung",
      count: 1,
    },
    {
      name: "IPhone 11",
      price: 15500000,
      brand: "Apple",
      count: 1,
    },
    {
      name: "OPPO Find X3 Pro",
      price: 19500000,
      brand: "OPPO",
      count: 3,
    },
  ];
  
  // 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product
  function addProduct(arr, name, price, brand, count) {
    arr.push({ name, price, brand, count });
  }
  
  // 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng
  function deleteName(arr, brandName) {
    for (let i = 0; i < arr.length; i++) {
      if (arr[i].brand.toLowerCase() == brandName.toLowerCase()) {
        arr.splice(i, 1);
      }
    }
    return arr;
  }
  
  // 8. Sắp xếp giỏ hàng theo price tăng dần
  function sortByPrice(arr) {
    let arr2 = arr.map((value) => value);
    return arr2.sort((a, b) => a.price - b.price);
  }
  console.log(sortByPrice(products));
  
  // 9. Sắp xếp giỏ hàng theo count giảm dần
  function sortByCountDesc(arr) {
    let arr2 = arr.map((value) => value);
    return arr2.sort((a, b) => b.count - a.count);
  }
  console.log(sortByCountDesc(products));
  
  // 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
  function randomProduct(arr) {
    let arr2 = arr.map((value) => value);
    let y = [];
    for (let i = 0; i < 2; i++) {
      let x = Math.floor(Math.random() * arr2.length);
      y.push(arr2[x]);
      arr2.splice(x, 1);
    }
    return y;
  }
  console.log(randomProduct(products));