from flask import Flask, render_template, request, redirect

app = Flask(__name__)

# قائمة المنتجات مسطرة لسهولة التحليل بواسطة ANTLR
products = [{"id": 0, "name": "Bag", "price": 300.0, "description": "A stylish black backpack with a sleek and modern design,Spacious, practical, and perfect for everyday use.", "image_url": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW91mHYZ54CX0KT-nH0wLLdoY6ch5WvPRgqeh0mYwGVA&s=10"},
 {"id": 1, "name": "Shirt", "price": 800.0, "description": "A comfortable and stylish shirt made from soft, breathable fabric.Simple, versatile, and perfect for everyday wear.", "image_url": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGm-2OpURzuk9_sExiPLXkaISpHiSvTuB97_ItD9PfWQ&s=10 "},
 {"id": 2, "name": "Pants", "price": 500.0, "description": "Comfortable and stylish pants designed for a perfect fit and everyday comfort. Versatile and easy to pair with any casual or modern outfit.", "image_url": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDSvJUmuwwP3O0jG7_cCV3vlYIzAxNpQWGPHtFj_-BxQ&s=10"},
 {"id": 3, "name": "Black shirt", "price": 300.0, "description": "A comfortable and stylish shirt made from soft, breathable fabric.Simple, versatile, and perfect for everyday wear.", "image_url": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGsrOZFJci5RHpykJmnGYgkgA8ESUZx9tFwFSaiH3HyQ&s=10"},
 {"id": 4, "name": "Shoes", "price": 200.0, "description": " Stylish and comfortable shoes designed to provide excellent support all day long.  Lightweight, versatile, and perfect for both casual and active looks.", "image_url": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPNY9X-Fg-o6t7h8Cf39S7jAWjmVyFUu-p7YzhSfuSyg&s"},
 {"id": 5, "name": "Hand Bag", "price": 300.0, "description": "Elegant and stylish handbag with a spacious design for your daily essentials.  Perfect for adding a sophisticated touch to any outfit.", "image_url": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2gLNNwO-pa82eQsDvOlOMUw_azzypK1rqE58-myvv9w&s=10"},
 {"id": 6, "name": "بص", "price": 55.0, "description": "بص", "image_url": "بصث"}]




def get_next_id():
    if not products:
        return 1
    return max(p["id"] for p in products) + 1


@app.route("/")
def home():
    return redirect("/view")


@app.route("/view")
def view_products():
    return render_template("showAllProduct.html", products=products)


@app.route("/add", methods=["GET", "POST"])
def add_product():
    if request.method == "POST":
        new_product = {
            "id": get_next_id(),
            "name": request.form["product_name"],
            "price": float(request.form["price"]),
            "description": request.form["description"],
            "image_url": request.form["image_url"]
        }
        products.append(new_product)
        message = "تمت إضافة المنتج بنجاح!"
    return render_template("addProduct.html", message=message)


@app.route("/details/<int:product_id>")
def product_details(product_id):
    product = next((p for p in products if p["id"] == product_id), None)
    return render_template("ShowProductDitels.html", product=product)


@app.route("/edit/<int:product_id>", methods=["GET", "POST"])
def edit_product(product_id):
    product = next((p for p in products if p["id"] == product_id), None)
    if product == None:
        return redirect("/view")
    if request.method == "POST":
        product["name"] = request.form["product_name"]
        product["price"] = float(request.form["price"])
        product["description"] = request.form["description"]
        product["image_url"] = request.form["image_url"]
        message = "تم تعديل المنتج بنجاح!"
    return render_template("editProduct.html", product=product, message=message)

@app.route("/delete/<int:product_id>", methods=["GET"])
def confirm_delete(product_id):
    product = next((p for p in products if p["id"] == product_id), None)
    if product == None:
        return redirect("/view")
    return render_template("deleteProduct.html", product=product)

@app.route("/delete/<int:product_id>", methods=["POST"])
def delete_product(product_id):
    # تعديل محتوى القائمة مباشرة دون الحاجة لاستخدام global
    filtered_products = [p for p in products if p["id"] != product_id]
    products.clear()
    products.extend(filtered_products)
    return redirect("/view")


if __name__ == "__main__":
    app.run(debug=True)
