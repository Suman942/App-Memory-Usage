# Dagger-Learning Kotlin Project

When I first started working on Android apps, I didn’t care much about memory. As long as the app ran, I was happy.

Until… 💥 one day, a user complained:

“Your app crashes right after opening on my phone.”

When I checked the logs, I saw the dreaded:

java.lang.OutOfMemoryError

That’s when I realized: I had no idea how Android managed memory under the hood.

In this post, let’s explore:
📌 How Android assigns memory to your app
📌 What happens when you cross the limits
📌 Why this knowledge is critical for every developer


📦 How Android OS Assigns Memory
When your app launches, Android doesn’t give it unlimited memory.

Instead, the OS allocates a specific memory limit to each app based on:

📱 The device’s total RAM

🎯 Your app’s target API level

This limit protects the system from one app hogging all resources.

| Parameter               | Value      |
|-------------------------|------------|
| Total Memory Assignable | **192 MB** |
| Initially Assigned      | **192 MB** |

At first launch, your app may get the full assignable memory.
Sounds generous, right? But here’s the catch 👇

🔄 Android Adjusts Memory Dynamically
The OS keeps a close eye on your app.

📌 Here’s what happens:
When your app is idle or backgrounded, the OS may reduce your memory allocation.

When your app comes back to the foreground, Android may increase allocation up to the assigned limit.

🗨️ Think of it like:
“Here’s 192 MB for now. But behave! If you don’t need it, I’m taking some back.”


| Scenario              | Memory Assigned |
|-----------------------|-----------------|
| Initial Launch        | 🔥 **192 MB**   |
| App goes idle         | ⬇️ **50 MB**    |
| Heavy Object Creation | ⬆️ **192 MB**   |


⚠️ What Happens If You Cross the Limit?
This is where things get scary.
If your app tries to use more memory than assigned:

❌ Android throws:
java.lang.OutOfMemoryError


😱 Common Mistakes Leading to OOM
Here are a few mistakes I’ve made (and maybe you too?):

🖼️ Loading giant images without scaling

♻️ Keeping references to Activities or Views after they’re destroyed (hello, memory leaks 👋)

📊 Using massive data structures without thinking about memory footprint

🔄 Background threads holding large objects alive forever

💡 Why You Should Care
Understanding memory management isn’t just for senior devs or system engineers.

It helps you:

✅ Avoid embarrassing crashes on low-RAM devices
✅ Build apps that feel faster and lighter
✅ Create a smooth experience even on older phones




## 👨‍💻 Author
**Suman Shil** – Android Developer  
[GitHub Profile](https://github.com/Suman942) | [LinkedIn](https://www.linkedin.com/in/suman-shil-204177191/)

